package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Calendar;
import java.util.List;

@Service
public class BetanoService {
    private final BookmakerService bookmakerService;
    private final TeamService teamService;
    private final EventService eventService;
    private final Market1x2Service market1x2Service;
    private final MarketOverUnder2PointFiveGoalsService marketOverUnder2PointFiveGoalsService;
    private final MarketGoalNoGoalService marketGoalNoGoalService;

    private final BetanoSheetService betanoSheetService;

    public BetanoService(BookmakerService bookmakerService, TeamService teamService, EventService eventService,
                         Market1x2Service market1x2Service, MarketOverUnder2PointFiveGoalsService marketOverUnder2PointFiveGoalsService,
                         MarketGoalNoGoalService marketGoalNoGoalService, BetanoSheetService betanoSheetService) {
        this.bookmakerService = bookmakerService;
        this.teamService = teamService;
        this.eventService = eventService;
        this.market1x2Service = market1x2Service;
        this.marketOverUnder2PointFiveGoalsService = marketOverUnder2PointFiveGoalsService;
        this.marketGoalNoGoalService = marketGoalNoGoalService;
        this.betanoSheetService = betanoSheetService;
    }

    public void scrappingBetano() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.betano.bg/en/sport/soccer/upcoming-matches-today/?sort=Leagues");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            WebElement button = driver.findElement(By.cssSelector(".sb-modal__close__btn"));
            button.click();

//             Opening all leagues and markets
            List<WebElement> svgArrowCollapsed = driver.findElements(By.className("sb-arrow--collapsed"));
            List<WebElement> svgArrowAll = driver.findElements(By.cssSelector(".sb-arrow.icon--clickable"));
            List<WebElement> testEls = driver.findElements(By.className("league-block__header"));

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);

            for (int i = svgArrowCollapsed.size() - 1; i < svgArrowAll.size(); i++) {
//                WebElement svg = svgArrowAll.get(i);
//                new Actions(driver)
//                        .click(svg)
//                        .perform();

                WebElement testEl = testEls.get(i);
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].click()", testEl);
            }

            List<WebElement> events = driver.findElements(By.cssSelector(".events-list__grid__event"));

            for (WebElement e : events) {
                WebElement dateAndTime = e.findElement(By.cssSelector(".events-list__grid__info__datetime"));
                WebElement participant = e.findElement(By.cssSelector(".events-list__grid__info__main__participants"));
                List<WebElement> markets = e.findElements(By.cssSelector(".table__markets__market"));

                String[] dateAndTimeSplit = dateAndTime.getText().split("\n");
                String[] dayAndMonth = dateAndTimeSplit[0].split("/");
                String[] hoursAndMinutes = dateAndTimeSplit[1].split(":");

                LocalDate date = LocalDate.of(year, Integer.parseInt(dayAndMonth[1]), Integer.parseInt(dayAndMonth[0]));
                LocalTime time = LocalTime.of(Integer.parseInt(hoursAndMinutes[0]), Integer.parseInt(hoursAndMinutes[1]));

                String[] participantsSplit = participant.getText().split("\n");

                Team teamOne = this.teamService.findTeamByName(participantsSplit[0], "www.betano.bg");
                Team teamTwo = this.teamService.findTeamByName(participantsSplit[1], "www.betano.bg");
                Championship currentChampionship = this.teamService.findTeamsChampionship(teamOne.getName(), teamTwo.getName());
                String identifier = date.toString() + time.toString() + teamOne.getName() + teamTwo.getName();
                Event event = this.eventService.findEventByIdentifier(identifier, date, time, teamOne, teamTwo, currentChampionship);
                Bookmaker bookmaker = this.bookmakerService.findBookmakerByName( "www.betano.bg","www.betano.bg");

                //Market1x2 logic
                if (!markets.get(0).getText().isEmpty()) {
                    String[] market1x2coefs = markets.get(0).getText().split("\n");
                    double coefficient1 = Double.parseDouble(market1x2coefs[0]);
                    double coefficientX = Double.parseDouble(market1x2coefs[1]);
                    double coefficient2 = Double.parseDouble(market1x2coefs[2]);

                    this.market1x2Service.generateMarket1x2Procedure(identifier, coefficient1, coefficientX, coefficient2, bookmaker, event);
                }

                //MarketOverUnder2PointFiveGoals logic;
                if (!markets.get(1).getText().isEmpty()) {
                    String[] marketOverUnderCoefs = markets.get(1).getText().split("\n");
                    String headingOver = marketOverUnderCoefs[0];
                    double coefficientOver = Double.parseDouble(marketOverUnderCoefs[1]);
                    double coefficientUnder = Double.parseDouble(marketOverUnderCoefs[3]);

                    if (headingOver.equals("O 2.5")) {
                        this.marketOverUnder2PointFiveGoalsService.generateMarketOverUnder2PointFiveProcedure(identifier, coefficientOver, coefficientUnder, bookmaker, event);
                    }
                }

                //MarketGoalNoGoal logic;
                if (!markets.get(2).getText().isEmpty()) {
                    String[] marketGoalNoGoalCoefs = markets.get(2).getText().split("\n");
                    double coefficientGoal = Double.parseDouble(marketGoalNoGoalCoefs[1]);
                    double coefficientNoGoal = Double.parseDouble(marketGoalNoGoalCoefs[3]);

                    this.marketGoalNoGoalService.generateMarketGoalNoGoalProcedure(identifier, coefficientGoal, coefficientNoGoal, bookmaker, event);
                }

                //BetanoSheet populating;
                String oneXTwoMarketBetano = !markets.get(0).getText().isEmpty() ? markets.get(0).getText() : "";
                String overUnderMarketBetano = !markets.get(1).getText().isEmpty() ? markets.get(1).getText() : "";
                String goalNoGoalMarketBetano = !markets.get(2).getText().isEmpty() ? markets.get(2).getText() : "";

                this.betanoSheetService.saveOrUpdateBetanoSheet(event, identifier, oneXTwoMarketBetano, overUnderMarketBetano, goalNoGoalMarketBetano);
            }

        } finally {
            driver.quit();
        }
    }
}

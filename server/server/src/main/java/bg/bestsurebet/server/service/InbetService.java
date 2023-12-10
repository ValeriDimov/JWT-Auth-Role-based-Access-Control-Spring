package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

@Service
public class InbetService {
    private final BookmakerService bookmakerService;
    private final TeamService teamService;
    private final EventService eventService;
    private final Market1x2Service market1x2Service;
    private final MarketOverUnder2PointFiveGoalsService marketOverUnder2PointFiveGoalsService;
    private final MarketBothTeamsToScoreService marketBothTeamsToScoreService;

    private final InbetSheetService inbetSheetService;

    public InbetService(BookmakerService bookmakerService, TeamService teamService, EventService eventService,
                        Market1x2Service market1x2Service, MarketOverUnder2PointFiveGoalsService marketOverUnder2PointFiveGoalsService,
                        MarketBothTeamsToScoreService marketBothTeamsToScoreService, InbetSheetService inbetSheetService) {
        this.bookmakerService = bookmakerService;
        this.teamService = teamService;
        this.eventService = eventService;
        this.market1x2Service = market1x2Service;
        this.marketOverUnder2PointFiveGoalsService = marketOverUnder2PointFiveGoalsService;
        this.marketBothTeamsToScoreService = marketBothTeamsToScoreService;
        this.inbetSheetService = inbetSheetService;
    }

    public void scrappingInbet() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://inbet.com/sports/soccer-1001/upcomingEvents");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            WebElement eventContent = driver.findElement(By.cssSelector(".content-wrapper--sport"));

            List<WebElement> eventsTab = eventContent.findElements(By.cssSelector(".react-tabs__tab"));
            WebElement eventTab = eventContent.findElement(By.cssSelector(".react-tabs__tab"));

            if (eventTab.getText().equals("Всички събития")) {
                new Actions(driver)
                        .click(eventTab)
                        .perform();

            } else {
                WebElement allEvents = eventsTab.get(1);
                new Actions(driver)
                        .click(allEvents)
                        .perform();
            }

            List<WebElement> hoursTab = driver.findElements(By.cssSelector(".hour-tabs__item"));
            WebElement eventsIn24Hours = hoursTab.get(2);
            new Actions(driver)
                    .click(eventsIn24Hours)
                    .perform();

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);

            //Opening all leagues with market1X2
            List<WebElement> svgArrowAll = driver.findElements(By.cssSelector(".header-level-2.header-level-2--expandable.header-level-2--"));
            List<WebElement> svgArrowAll2 = eventContent.findElements(By.cssSelector(".accordion--level-2"));
            List<WebElement> svgArrowExpanded = eventContent.findElements(By
                    .cssSelector(".accordion--level-2--open"));

            for (int i = svgArrowExpanded.size(); i < svgArrowAll2.size(); i++) {
                WebElement svg = svgArrowAll.get(i);
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].click()", svg);
            }

            //Market1x2 logic
            List<WebElement> events = driver.findElements(By.cssSelector(".event__wrapper"));

            for (WebElement e : events) {
                WebElement dateAndTime = e.findElement(By.cssSelector(".event-meta__item.time"));
                WebElement participant = e.findElement(By.cssSelector(".event-header__teams"));
                WebElement market1X2Coefficients = e.findElement(By.cssSelector(".event-body"));

                String[] dateAndTimeSplit = dateAndTime.getText().split(" ");
                String[] hoursAndMinutes = dateAndTimeSplit[1].split(":");

                LocalDate date = LocalDate.now();

                if (dateAndTimeSplit[0].equals("Утре,")) {
                    date = date.plusDays(1);
                }

                LocalTime time = LocalTime.of(Integer.parseInt(hoursAndMinutes[0]), Integer.parseInt(hoursAndMinutes[1]));

                String[] participantsSplit = participant.getText().split("\n");

                Team teamOne = this.teamService.findTeamByName(participantsSplit[0], "www.inbet.com");
                Team teamTwo = this.teamService.findTeamByName(participantsSplit[1], "www.inbet.com");
                Championship currentChampionship = this.teamService.findTeamsChampionship(teamOne.getName(), teamTwo.getName());
                String identifier = date.toString() + time.toString() + teamOne.getName() + teamTwo.getName();
                Event event = this.eventService.findEventByIdentifier(identifier, date, time, teamOne, teamTwo, currentChampionship);
                Bookmaker bookmaker = this.bookmakerService.findBookmakerByName( "www.inbet.com","www.inbet.com");

                if (!market1X2Coefficients.getText().isEmpty()) {
                    String[] market1x2coefs = market1X2Coefficients.getText().split("\n");

                    if (market1x2coefs.length == 3) {
                        double coefficient1 = Double.parseDouble(market1x2coefs[0]);
                        double coefficientX = Double.parseDouble(market1x2coefs[1]);
                        double coefficient2 = Double.parseDouble(market1x2coefs[2]);

                        this.market1x2Service.generateMarket1x2Procedure(identifier, coefficient1, coefficientX, coefficient2, bookmaker, event);
                    }
                }

                //InbetSheet populating with market1X2;
                String oneXTwoMarketInbet = !market1X2Coefficients.getText().isEmpty() ? market1X2Coefficients.getText() : "";
                String overUnderMarketInbet = "";
                String bothTeamsToScoreMarketInbet = "";

                this.inbetSheetService.saveOrUpdateInbetSheet(event, identifier, oneXTwoMarketInbet, overUnderMarketInbet, bothTeamsToScoreMarketInbet);
            }

            //Opening all leagues with MarketOverUnder2PointFiveGoals
            WebElement marketsDropdown = driver.findElement(By.cssSelector(".dropdown"));
            WebElement dropdown = marketsDropdown.findElement(By.cssSelector(".btn-dropdown"));
            new Actions(driver)
                    .click(dropdown)
                    .perform();

            List<WebElement> markets = marketsDropdown.findElements(By.cssSelector(".dropdown-item"));
            new Actions(driver)
                    .click(markets.get(1))
                    .perform();

            svgArrowAll = driver.findElements(By.cssSelector(".header-level-2.header-level-2--expandable.header-level-2--"));
            svgArrowAll2 = eventContent.findElements(By.cssSelector(".accordion--level-2"));
            svgArrowExpanded = eventContent.findElements(By
                    .cssSelector(".accordion--level-2--open"));

            for (int i = svgArrowExpanded.size(); i < svgArrowAll2.size(); i++) {
                WebElement svg = svgArrowAll.get(i);
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].click()", svg);
            }

            //MarketOverUnder2PointFiveGoals logic;
            events = driver.findElements(By.cssSelector(".event__wrapper"));

            for (WebElement e : events) {
                WebElement dateAndTime = e.findElement(By.cssSelector(".event-meta__item.time"));
                WebElement participant = e.findElement(By.cssSelector(".event-header__teams"));
                WebElement marketOverUnderCoefficients = e.findElement(By.cssSelector(".event-body"));

                String[] dateAndTimeSplit = dateAndTime.getText().split(" ");
                String[] hoursAndMinutes = dateAndTimeSplit[1].split(":");

                LocalDate date = LocalDate.now();

                if (dateAndTimeSplit[0].equals("Утре,")) {
                    date = date.plusDays(1);
                }

                LocalTime time = LocalTime.of(Integer.parseInt(hoursAndMinutes[0]), Integer.parseInt(hoursAndMinutes[1]));

                String[] participantsSplit = participant.getText().split("\n");

                Team teamOne = this.teamService.findTeamByName(participantsSplit[0], "www.inbet.com");
                Team teamTwo = this.teamService.findTeamByName(participantsSplit[1], "www.inbet.com");
                Championship currentChampionship = this.teamService.findTeamsChampionship(teamOne.getName(), teamTwo.getName());
                String identifier = date.toString() + time.toString() + teamOne.getName() + teamTwo.getName();
                Event event = this.eventService.findEventByIdentifier(identifier, date, time, teamOne, teamTwo, currentChampionship);
                Bookmaker bookmaker = this.bookmakerService.findBookmakerByName( "www.inbet.com","www.inbet.com");

                if (!marketOverUnderCoefficients.getText().isEmpty()) {
                    String[] marketOverUnderCoefs = marketOverUnderCoefficients.getText().split("\n");

                    if (marketOverUnderCoefs.length == 4) {
                        double coefficientOver = Double.parseDouble(marketOverUnderCoefs[1]);
                        double coefficientUnder = Double.parseDouble(marketOverUnderCoefs[3]);

                        this.marketOverUnder2PointFiveGoalsService.generateMarketOverUnder2PointFiveProcedure(identifier, coefficientOver, coefficientUnder, bookmaker, event);
                    }
                }

                //InbetSheet populating with overUnderMarket;
                String overUnderMarketInbet = !marketOverUnderCoefficients.getText().isEmpty() ? marketOverUnderCoefficients.getText() : "";

                this.inbetSheetService.saveOrUpdateInbetSheet(event, identifier, overUnderMarketInbet);
            }

            //Opening all leagues with MarketBothTeamsToScore
            dropdown = marketsDropdown.findElement(By.cssSelector(".btn-dropdown"));
            new Actions(driver)
                    .click(dropdown)
                    .perform();

            markets = marketsDropdown.findElements(By.cssSelector(".dropdown-item"));
            new Actions(driver)
                    .click(markets.get(5))
                    .perform();

            svgArrowAll = driver.findElements(By.cssSelector(".header-level-2.header-level-2--expandable.header-level-2--"));
            svgArrowAll2 = eventContent.findElements(By.cssSelector(".accordion--level-2"));
            svgArrowExpanded = eventContent.findElements(By
                    .cssSelector(".accordion--level-2--open"));

            for (int i = svgArrowExpanded.size(); i < svgArrowAll2.size(); i++) {
                WebElement svg = svgArrowAll.get(i);
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].click()", svg);
            }

            //MarketBothTeamsToScore logic;
            events = driver.findElements(By.cssSelector(".event__wrapper"));

            for (WebElement e : events) {
                WebElement dateAndTime = e.findElement(By.cssSelector(".event-meta__item.time"));
                WebElement participant = e.findElement(By.cssSelector(".event-header__teams"));
                WebElement marketBothTeamsToScoreCoefficients = e.findElement(By.cssSelector(".event-body"));

                String[] dateAndTimeSplit = dateAndTime.getText().split(" ");
                String[] hoursAndMinutes = dateAndTimeSplit[1].split(":");

                LocalDate date = LocalDate.now();

                if (dateAndTimeSplit[0].equals("Утре,")) {
                    date = date.plusDays(1);
                }

                LocalTime time = LocalTime.of(Integer.parseInt(hoursAndMinutes[0]), Integer.parseInt(hoursAndMinutes[1]));

                String[] participantsSplit = participant.getText().split("\n");

                Team teamOne = this.teamService.findTeamByName(participantsSplit[0], "www.inbet.com");
                Team teamTwo = this.teamService.findTeamByName(participantsSplit[1], "www.inbet.com");
                Championship currentChampionship = this.teamService.findTeamsChampionship(teamOne.getName(), teamTwo.getName());
                String identifier = date.toString() + time.toString() + teamOne.getName() + teamTwo.getName();
                Event event = this.eventService.findEventByIdentifier(identifier, date, time, teamOne, teamTwo, currentChampionship);
                Bookmaker bookmaker = this.bookmakerService.findBookmakerByName( "www.inbet.com","www.inbet.com");

                if (!marketBothTeamsToScoreCoefficients.getText().isEmpty()) {
                    String[] marketBothTeamsToScoreCoefs = marketBothTeamsToScoreCoefficients.getText().split("\n");

                    if (marketBothTeamsToScoreCoefs.length == 2) {
                        double coefficientYes = Double.parseDouble(marketBothTeamsToScoreCoefs[0]);
                        double coefficientNo = Double.parseDouble(marketBothTeamsToScoreCoefs[1]);

                        this.marketBothTeamsToScoreService.generateMarketBothTeamsToScoreProcedure(identifier, coefficientYes, coefficientNo, bookmaker, event);
                    }
                }

                //InbetSheet populating with MarketBothTeamsToScore;
                String marketBothTeamsToScore = !marketBothTeamsToScoreCoefficients.getText().isEmpty() ? marketBothTeamsToScoreCoefficients.getText() : "";
                boolean isBothTeamsToScore = true;

                this.inbetSheetService.saveOrUpdateInbetSheet(identifier, marketBothTeamsToScore, isBothTeamsToScore);
            }

            //Opening top leagues with 0% margin of market1X2
            driver.get("https://inbet.com/sports");
            WebElement openTopLeagues = driver.findElement(By.cssSelector(".header-link"));
            openTopLeagues.click();

            events = driver.findElements(By.cssSelector(".event__wrapper"));

            for (WebElement e : events) {
                WebElement dateAndTime = e.findElement(By.cssSelector(".event-meta__item.time"));
                WebElement participant = e.findElement(By.cssSelector(".event-header__teams"));
                WebElement market1X2Coefficients = e.findElement(By.cssSelector(".event-body"));

                String[] dateAndTimeSplit = dateAndTime.getText().split(" ");
                String[] hoursAndMinutes = dateAndTimeSplit[1].split(":");

                if (dateAndTimeSplit[0].equals("Утре,") || dateAndTimeSplit[0].equals("Днес,")) {
                    LocalDate date = LocalDate.now();

                    if (dateAndTimeSplit[0].equals("Утре,")) {
                    date = date.plusDays(1);
                    }

                    LocalTime time = LocalTime.of(Integer.parseInt(hoursAndMinutes[0]), Integer.parseInt(hoursAndMinutes[1]));

                    String[] participantsSplit = participant.getText().split("\n");

                    Team teamOne = this.teamService.findTeamByName(participantsSplit[0], "www.inbet.com");
                    Team teamTwo = this.teamService.findTeamByName(participantsSplit[1], "www.inbet.com");
                    Championship currentChampionship = this.teamService.findTeamsChampionship(teamOne.getName(), teamTwo.getName());
                    String identifier = date.toString() + time.toString() + teamOne.getName() + teamTwo.getName();
                    Event event = this.eventService.findEventByIdentifier(identifier, date, time, teamOne, teamTwo, currentChampionship);
                    Bookmaker bookmaker = this.bookmakerService.findBookmakerByName( "www.inbet.com","www.inbet.com");

                    if (!market1X2Coefficients.getText().isEmpty()) {
                        String[] market1x2coefs = market1X2Coefficients.getText().split("\n");

                        if (market1x2coefs.length == 3) {
                            double coefficient1 = Double.parseDouble(market1x2coefs[0]);
                            double coefficientX = Double.parseDouble(market1x2coefs[1]);
                            double coefficient2 = Double.parseDouble(market1x2coefs[2]);

                            this.market1x2Service.generateMarket1x2Procedure(identifier, coefficient1, coefficientX, coefficient2, bookmaker, event);
                        }
                    }
                    //InbetSheet populating with 0% margin of market1X2;
                    String oneXTwoMarketInbet = !market1X2Coefficients.getText().isEmpty() ? market1X2Coefficients.getText() : "";

                    this.inbetSheetService.saveOrUpdateInbetSheet(identifier, oneXTwoMarketInbet);
                }
            }

        } finally {
            driver.quit();
        }
    }
}

package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.*;
import bg.bestsurebet.server.model.entity.sheet.BetanoSheet;
import bg.bestsurebet.server.repository.BetanoSheetRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@EnableScheduling
@Service
public class BetanoService {

    private BetanoSheetRepository betanoSheetRepository;

    private final BookmakerService bookmakerService;
    private final TeamService teamService;
    private final SportService sportService;
    private final ChampionshipService championshipService;
    private final EventService eventService;
    private final Market1x2Service market1x2Service;
    private final MarketOverUnder2PointFiveGoalsService marketOverUnder2PointFiveGoalsService;
    private final MarketGoalNoGoalService marketGoalNoGoalService;

    public BetanoService(BetanoSheetRepository betanoSheetRepository, BookmakerService bookmakerService, TeamService teamService, SportService sportService,
                         ChampionshipService championshipService, EventService eventService, Market1x2Service market1x2Service,
                         MarketOverUnder2PointFiveGoalsService marketOverUnder2PointFiveGoalsService, MarketGoalNoGoalService marketGoalNoGoalService) {
        this.betanoSheetRepository = betanoSheetRepository;
        this.bookmakerService = bookmakerService;
        this.teamService = teamService;
        this.sportService = sportService;
        this.championshipService = championshipService;
        this.eventService = eventService;
        this.market1x2Service = market1x2Service;
        this.marketOverUnder2PointFiveGoalsService = marketOverUnder2PointFiveGoalsService;
        this.marketGoalNoGoalService = marketGoalNoGoalService;
    }

    @Scheduled(fixedDelay = 60 * 60 * 1000, initialDelay = 1 * 20 * 1000)
    public void scrappingBetano() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.betano.bg/en/sport/soccer/upcoming-matches-today/?sort=Leagues");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.manage().window().maximize();

//            WebElement button = driver.findElement(By.cssSelector(".sb-modal__close__btn"));
//            button.click();

//             Opening all leagues and markets
            List<WebElement> svgArrowCollapsed = driver.findElements(By.className("sb-arrow--collapsed"));
            List<WebElement> svgArrowAll = driver.findElements(By.cssSelector(".sb-arrow.icon--clickable"));

            for (int i = svgArrowCollapsed.size() - 1; i < svgArrowAll.size(); i++) {
                WebElement svg = svgArrowAll.get(i);
                new Actions(driver)
                        .click(svg)
                        .perform();
            }

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);

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

                Championship currentChampionship = this.teamService.findTeamsChampionship(teamOne.getName(), teamTwo.getName(), "www.betano.bg");

                String identifier = date.toString() + time.toString() + teamOne.getName() + teamTwo.getName();

                Optional<Event> eventOptional = this.eventService.findEventByIdentifier(identifier);

                Event event = eventOptional.isPresent() ?
                                eventOptional.get() :
                        this.eventService.save(new Event()
                                        .setDate(LocalDate.of(year, Integer.parseInt(dayAndMonth[1]), Integer.parseInt(dayAndMonth[0])))
                                        .setTime(LocalTime.of(Integer.parseInt(hoursAndMinutes[0]), Integer.parseInt(hoursAndMinutes[1])))
                                        .setTeamOne(teamOne)
                                        .setTeamTwo(teamTwo)
                                        .setChampionship(currentChampionship)
                                        .setIdentifier(identifier));

                Optional<Bookmaker> bookmakerOptional = this.bookmakerService.findBookmakerByName("www.betano.bg");

                //TODO: Market1x2 logic check to be implemented; else logic when there is no market and what to save in database;

                Market1x2 market1x2 = new Market1x2();
                if (!markets.get(0).getText().isEmpty()) {

                    String[] market1x2coefs = markets.get(0).getText().split("\n");
                    double margin1x2 =
                                    100 /
                                    Double.parseDouble(market1x2coefs[0]) /
                                    (1 / Double.parseDouble(market1x2coefs[0]) + 1 / Double.parseDouble(market1x2coefs[1]) + 1 / Double.parseDouble(market1x2coefs[2])) *
                                    Double.parseDouble(market1x2coefs[0]) -
                                    100;

                    Optional<Market1x2> optionalMarket1x2 = this.market1x2Service.findMarket1x2ByEventIdentifier(identifier);

                    if (optionalMarket1x2.isPresent()) {
                        market1x2 = optionalMarket1x2.get();
                        market1x2
                                .setCoefficient1(Double.parseDouble(market1x2coefs[0]))
                                .setCoefficientX(Double.parseDouble(market1x2coefs[1]))
                                .setCoefficient2(Double.parseDouble(market1x2coefs[2]))
                                .setMargin(margin1x2);

                        this.market1x2Service.save(market1x2);
                    } else {
                        market1x2
                                .setCoefficient1(Double.parseDouble(market1x2coefs[0]))
                                .setCoef1Bookmaker(bookmakerOptional.isPresent() ?
                                        bookmakerOptional.get() : this.bookmakerService.save(new Bookmaker().setName("www.betano.bg")))
                                .setCoefficientX(Double.parseDouble(market1x2coefs[1]))
                                .setCoefXBookmaker(bookmakerOptional.isPresent() ?
                                        bookmakerOptional.get() : this.bookmakerService.save(new Bookmaker().setName("www.betano.bg")))
                                .setCoefficient2(Double.parseDouble(market1x2coefs[2]))
                                .setCoef2Bookmaker(bookmakerOptional.isPresent() ?
                                        bookmakerOptional.get() : this.bookmakerService.save(new Bookmaker().setName("www.betano.bg")))
                                .setMargin(margin1x2)
                                .setEvent(event);

                        this.market1x2Service.save(market1x2);
                    }

                }
                //TODO: MarketOverUnder2PointFiveGoals logic check to be implemented;

                MarketOverUnder2PointFiveGoals marketOverUnder2PointFiveGoals = new MarketOverUnder2PointFiveGoals();
                if (!markets.get(1).getText().isEmpty()) {

                    String[] marketOverUnderCoefs = markets.get(1).getText().split("\n");
                    double marginOverUnder =
                                    100 /
                                    Double.parseDouble(marketOverUnderCoefs[1]) /
                                    (1 / Double.parseDouble(marketOverUnderCoefs[1]) + 1 / Double.parseDouble(marketOverUnderCoefs[3])) *
                                    Double.parseDouble(marketOverUnderCoefs[1]) -
                                    100;

                    Optional<MarketOverUnder2PointFiveGoals> optionalMarketOverUnder2PointFiveGoals =
                            this.marketOverUnder2PointFiveGoalsService.findMarketOverUnder2PointFiveGoalsByEventIdentifier(identifier);

                    if (optionalMarketOverUnder2PointFiveGoals.isPresent()) {
                        marketOverUnder2PointFiveGoals = optionalMarketOverUnder2PointFiveGoals.get();
                        marketOverUnder2PointFiveGoals
                                .setCoefficientOver(Double.parseDouble(marketOverUnderCoefs[1]))
                                .setCoefficientUnder(Double.parseDouble(marketOverUnderCoefs[3]))
                                .setMargin(marginOverUnder);

                        this.marketOverUnder2PointFiveGoalsService.save(marketOverUnder2PointFiveGoals);
                    } else {
                        marketOverUnder2PointFiveGoals
                                .setCoefficientOver(Double.parseDouble(marketOverUnderCoefs[1]))
                                .setCoefficientOverBookmaker(bookmakerOptional.isPresent() ?
                                        bookmakerOptional.get() : this.bookmakerService.save(new Bookmaker().setName("www.betano.bg")))
                                .setCoefficientUnder(Double.parseDouble(marketOverUnderCoefs[3]))
                                .setCoefficientUnderBookmaker(bookmakerOptional.isPresent() ?
                                        bookmakerOptional.get() : this.bookmakerService.save(new Bookmaker().setName("www.betano.bg")))
                                .setMargin(marginOverUnder)
                                .setEvent(event);

                        this.marketOverUnder2PointFiveGoalsService.save(marketOverUnder2PointFiveGoals);
                    }
                }
                //TODO: MarketGoalNoGoal logic check to be implemented from other bookmakers websites;

                MarketGoalNoGoal marketGoalNoGoal = new MarketGoalNoGoal();
                if (!markets.get(2).getText().isEmpty()) {

                    String[] marketGoalNoGoalCoefs = markets.get(2).getText().split("\n");
                    double marginGoalNoGoal =
                            100 /
                            Double.parseDouble(marketGoalNoGoalCoefs[1]) /
                            (1 / Double.parseDouble(marketGoalNoGoalCoefs[1]) + 1 / Double.parseDouble(marketGoalNoGoalCoefs[3])) *
                            Double.parseDouble(marketGoalNoGoalCoefs[1]) -
                            100;

                    Optional<MarketGoalNoGoal> optionalMarketGoalNoGoal = this.marketGoalNoGoalService.findMarketGoalNoGoalByEventIdentifier(identifier);

                    if (optionalMarketGoalNoGoal.isPresent()) {
                        marketGoalNoGoal = optionalMarketGoalNoGoal.get();
                        marketGoalNoGoal
                                .setCoefficientGoal(Double.parseDouble(marketGoalNoGoalCoefs[1]))
                                .setCoefficientNoGoal(Double.parseDouble(marketGoalNoGoalCoefs[3]))
                                .setMargin(marginGoalNoGoal);

                        this.marketGoalNoGoalService.save(marketGoalNoGoal);
                    } else {
                        marketGoalNoGoal
                                .setCoefficientGoal(Double.parseDouble(marketGoalNoGoalCoefs[1]))
                                .setCoefficientGoalBookmaker(bookmakerOptional.isPresent() ?
                                        bookmakerOptional.get() : this.bookmakerService.save(new Bookmaker().setName("www.betano.bg")))
                                .setCoefficientNoGoal(Double.parseDouble(marketGoalNoGoalCoefs[3]))
                                .setCoefficientNoGoalBookmaker(bookmakerOptional.isPresent() ?
                                        bookmakerOptional.get() : this.bookmakerService.save(new Bookmaker().setName("www.betano.bg")))
                                .setMargin(marginGoalNoGoal)
                                .setEvent(event);

                        this.marketGoalNoGoalService.save(marketGoalNoGoal);
                    }

                }

                BetanoSheet betanoSheet = new BetanoSheet()
                        .setEvent(event)
                        .setIdentifier(identifier)
                        .setOneXTwo(!markets.get(0).getText().isEmpty() ? markets.get(0).getText() : "")
                        .setOverUnder(!markets.get(1).getText().isEmpty() ? markets.get(1).getText() : "")
                        .setGoalNoGoal(!markets.get(2).getText().isEmpty() ? markets.get(2).getText() : "");

                this.betanoSheetRepository.save(betanoSheet);
            }

        } finally {
            driver.quit();
        }
    }
}

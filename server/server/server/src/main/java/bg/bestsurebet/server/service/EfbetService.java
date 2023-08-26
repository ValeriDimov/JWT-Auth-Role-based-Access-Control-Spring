package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Bookmaker;
import bg.bestsurebet.server.model.entity.Championship;
import bg.bestsurebet.server.model.entity.Event;
import bg.bestsurebet.server.model.entity.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@EnableScheduling
@Service
public class EfbetService {
    private final TeamService teamService;
    private final EventService eventService;
    private final BookmakerService bookmakerService;
    private final Market1x2Service market1x2Service;
    private final EfbetSheetService efbetSheetService;

    public EfbetService(TeamService teamService, EventService eventService, BookmakerService bookmakerService,
                        Market1x2Service market1x2Service, EfbetSheetService efbetSheetService) {
        this.teamService = teamService;
        this.eventService = eventService;
        this.bookmakerService = bookmakerService;
        this.market1x2Service = market1x2Service;
        this.efbetSheetService = efbetSheetService;
    }

    @Scheduled(fixedDelay = 65 * 60 * 1000, initialDelay = 5 * 60 * 1000)
    public void scrapping() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        String webAddressPage0= "https://www.efbet.com/UK/sports#action=program&idfosporttype=FBL&page=0";
        String webAddressPage0= "https://www.efbet.com/UK/sports#action=program&idfosporttype=FBL&page=0" + "&tab-date=" + LocalDate.now().toString();

        try {
            driver.get(webAddressPage0);
            driver.manage().window().maximize();

            collectEvents(driver);

            try {
                WebElement pagesTable = driver.findElement(By.className("pager"));
                List<WebElement> pages = pagesTable.findElements(By.tagName("a"));

                for (int i = 0; i < pages.size() - 1; i++) {
                    String webAddress = "https://www.efbet.com/UK/sports#action=program&idfosporttype=FBL&page=" + (i + 1) + "&tab-date=" + LocalDate.now().toString();
                    driver.navigate().to(webAddress);
                    driver.navigate().refresh();

                    WebElement foo = new WebDriverWait(driver, Duration.ofSeconds(10))
                            .until(d -> d.findElement(By.cssSelector(".countdown")));

                    collectEvents(driver);
                }

            } catch (Exception e) {
                System.out.println("No more pages than 1");
            }

        } catch (Exception ex) {
            System.out.println("Something went wrong. on " + System.lineSeparator() + webAddressPage0);

        } finally {
            driver.quit();
        }
    }

    private void collectEvents(WebDriver driver) {
        List<WebElement> eventsFirstGroup = driver.findElements(By.cssSelector(".row0"));
        List<WebElement> eventsSecondGroup = driver.findElements(By.cssSelector(".row1"));

        List<WebElement> events = new ArrayList<>();
        events.addAll(eventsFirstGroup);
        events.addAll(eventsSecondGroup);

        for (WebElement e : events) {
            WebElement eventTime = e.findElement(By.cssSelector(".countdown"));
            WebElement participant = e.findElement(By.tagName("a"));
            List<WebElement> coefficients = e.findElements(By.cssSelector(".prc"));

            if (!eventTime.getText().isEmpty() && !participant.getText().isEmpty() && (!coefficients.get(0).getText().isEmpty() && coefficients.size() == 3)) {
                String[] hoursAndMinutes = eventTime.getText().charAt(0) == '*' ? eventTime.getText().split(" ") : eventTime.getText().split(":");

                LocalDate date = LocalDate.now();
                LocalTime currentTime = LocalTime.now();
                LocalTime time = currentTime;

                if (eventTime.getText().charAt(0) == '*') {
                    String[] mins = hoursAndMinutes[1].split("min");
                    time = currentTime.plusMinutes(Integer.parseInt(mins[0]));
                } else {
                    time = LocalTime.of(Integer.parseInt(hoursAndMinutes[0]), Integer.parseInt(hoursAndMinutes[1]));
                }

                String[] participants = participant.getText().split(" vs ");

                Team teamOne = this.teamService.findTeamByName(participants[0], "www.efbet.com");
                Team teamTwo = this.teamService.findTeamByName(participants[1], "www.efbet.com");
                Championship currentChampionship = this.teamService.findTeamsChampionship(teamOne.getName(), teamTwo.getName(), "www.efbet.com");
                String identifier = date.toString() + time.toString() + teamOne.getName() + teamTwo.getName();
                Event event = this.eventService.findEventByIdentifier(identifier, date, time, teamOne, teamTwo, currentChampionship);
                Bookmaker bookmaker = this.bookmakerService.findBookmakerByName( "www.efbet.com","www.efbet.com");

                //Market1x2 logic
                double coefficient1 = Double.parseDouble(coefficients.get(0).getText());
                double coefficientX = Double.parseDouble(coefficients.get(1).getText());
                double coefficient2 = Double.parseDouble(coefficients.get(2).getText());

                this.market1x2Service.generateMarket1x2Procedure(identifier, coefficient1, coefficientX, coefficient2, bookmaker, event);

                //EfbetSheet populating;
                String oneXTwoMarketEfbet = coefficient1 + " " + coefficientX + coefficient2;

                this.efbetSheetService.saveOrUpdateEfbetSheet(event, identifier, oneXTwoMarketEfbet);
            }
        }
    }
}

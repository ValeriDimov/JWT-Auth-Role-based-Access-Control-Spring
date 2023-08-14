package bg.bestsurebet.server.service;

import bg.bestsurebet.server.repository.EventRepository;
import bg.bestsurebet.server.repository.TeamRepository;
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
import java.util.ArrayList;
import java.util.List;

@EnableScheduling
@Service
public class EfbetService {

    private final TeamRepository teamRepository;
    private final EventRepository eventRepository;

    public EfbetService(TeamRepository teamRepository, EventRepository eventRepository) {
        this.teamRepository = teamRepository;
        this.eventRepository = eventRepository;
    }

    @Scheduled(fixedDelay = 60 * 60 * 1000, initialDelay = 5 * 60 * 1000)
    public void scrapping() {
        WebDriver driver = new ChromeDriver();

        String webAddressPage0 = "https://www.efbet.com/UK/sports#action=program&idfosporttype=FBL&page=0";

        try {

            driver.get(webAddressPage0);

            driver.manage().window().maximize();
            WebElement foo = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(d -> d.findElement(By.cssSelector(".countdown")));

            collectEvents(driver);

            try {
                WebElement pagesTable = driver.findElement(By.className("pager"));
                List<WebElement> pages = pagesTable.findElements(By.tagName("a"));

                for (int i = 0; i < pages.size() - 1; i++) {
                    String webAddress = "https://www.efbet.com/UK/sports#action=program&idfosporttype=FBL&page=" + (i + 1);
                    driver.get(webAddress);

                    foo = new WebDriverWait(driver, Duration.ofSeconds(3))
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

    private static void collectEvents(WebDriver driver) {
        List<WebElement> eventsFirstGroup = driver.findElements(By.cssSelector(".row0"));
        List<WebElement> eventsSecondGroup = driver.findElements(By.cssSelector(".row1"));

        List<WebElement> events = new ArrayList<>();
        events.addAll(eventsFirstGroup);
        events.addAll(eventsSecondGroup);

        LocalDate today = LocalDate.now();

        for (WebElement e : events) {
            WebElement timeAndDate = e.findElement(By.cssSelector(".countdown"));
            WebElement participant = e.findElement(By.tagName("a"));
            List<WebElement> coefficients = e.findElements(By.cssSelector(".prc"));

            if (!timeAndDate.getText().isEmpty() && !participant.getText().isEmpty() && (!coefficients.get(0).getText().isEmpty() && coefficients.size() == 3)) {
                System.out.println(today);

                System.out.println(timeAndDate.getText());

                String[] participants = participant.getText().split(" vs ");
                System.out.println(participants[0]);
                System.out.println(participants[1]);

                System.out.println(coefficients.get(0).getText());
                System.out.println(coefficients.get(1).getText());
                System.out.println(coefficients.get(2).getText());

            }
        }
    }
}

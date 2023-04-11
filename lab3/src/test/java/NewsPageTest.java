import org.example.driver.BrowserDrivers;
import org.example.gesm.NewsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsPageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, NewsPage> newsPageMap;


    @BeforeEach
    public void setUp() throws IOException {
        browserDrivers = new BrowserDrivers();
        newsPageMap = new HashMap<>();
        browserDrivers.getDrivers().forEach((key, driver) -> driver.get("https://www.gismeteo.ru/news/"));
        browserDrivers.getDrivers().forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.getDrivers().forEach((key, driver) -> newsPageMap.put(key, new NewsPage(driver)));
        browserDrivers.getDrivers().forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }


    @AfterEach
    public void closeWindow() {
        browserDrivers.closeBrowser();
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @DisplayName("Animal button click test")
    public void AnimalButtonClickTest() {
        newsPageMap.forEach((key, newsPage) -> {
            newsPage.AnimalBtnClick();
            assertEquals(newsPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/news/animals/");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @DisplayName("Auto button click test")
    public void AutoButtonClickTest() {
        newsPageMap.forEach((key, newsPage) -> {
            newsPage.AutoBtnClick();
            assertEquals(newsPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/news/auto/");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @DisplayName("Covid button click test")
    public void CovidButtonClickTest() {
        newsPageMap.forEach((key, newsPage) -> {
            newsPage.CovidBtnClick();
            assertEquals(newsPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/news/coronavirus/");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @DisplayName("Science button click test")
    public void ScienceButtonClickTest() {
        newsPageMap.forEach((key, newsPage) -> {
            newsPage.ScienceBtnClick();
            assertEquals(newsPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/news/science/");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @DisplayName("Nature button click test")
    public void NatureButtonClickTest() {
        newsPageMap.forEach((key, newsPage) -> {
            newsPage.NatureBtnClick();
            assertEquals(newsPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/news/nature/");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @DisplayName("Weather button click test")
    public void WeatherButtonClickTest() {
        newsPageMap.forEach((key, newsPage) -> {
            newsPage.WeatherBtnClick();
            assertEquals(newsPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/news/weather/");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

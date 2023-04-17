
import org.example.driver.BrowserDrivers;
import org.example.gesm.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, MainPage> mainPageMap;


    @BeforeEach
    public void setUp() throws IOException {
        browserDrivers = new BrowserDrivers();
        mainPageMap = new HashMap<>();
        browserDrivers.getDrivers().forEach((key, driver) -> driver.get("https://www.gismeteo.ru/"));
        browserDrivers.getDrivers().forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.getDrivers().forEach((key, driver) -> mainPageMap.put(key, new MainPage(driver)));
        browserDrivers.getDrivers().forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }


    @AfterEach
    public void closeWindow() {
        browserDrivers.closeBrowser();
    }

    @Test
    @DisplayName("News button click test")
    public void NewsButtonClickTest() {
        mainPageMap.forEach((key, mainPage) -> {
            mainPage.NewsBtnClick();
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/news/");
        });
    }

    @Test
    @DisplayName("Maps button click test")
    public void MapsButtonClickTest() {
        mainPageMap.forEach((key, mainPage) -> {
            mainPage.MapsBtnClick();
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/maps/");
        });
    }

    @Test
    @DisplayName("Informs button click test")
    public void InformButtonClickTest() {
        mainPageMap.forEach((key, mainPage) -> {
            mainPage.InformsBtnClick();
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/informers/");
        });
    }

    @Test
    @DisplayName("Apps button click test")
    public void AppsButtonClickTest() {
        mainPageMap.forEach((key, mainPage) -> {
            mainPage.AppsBtnClick();
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/soft/");
        });
    }

    @Test
    @DisplayName("Search city weather test")
    public void SearchInputTest() {
        mainPageMap.forEach((key, mainPage) -> {
            mainPage.SearchInputClick("Алматы");
            new WebDriverWait(mainPage.getWebDriver(), Duration.ofSeconds(25)).until(ExpectedConditions.urlContains(
                    "https://www.gismeteo.ru/weather-almaty-5205/"));
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/weather-almaty-5205/");
        });
    }

    @Test
    @DisplayName("Switch city weather test")
    public void EditCityButtonClickTest() {
        mainPageMap.forEach((key, mainPage) -> {
            mainPage.EditCityBtnClick();
            WebElement input = mainPage.getWebDriver().findElement(By.xpath(
                    "//input[@type='search']"));
            new WebDriverWait(mainPage.getWebDriver(), Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(input));
            input.sendKeys("Алматы");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            WebElement accept = mainPage.getWebDriver().findElement(By.xpath(
                    "//div[@data-id='5205']"));
            new WebDriverWait(mainPage.getWebDriver(), Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(accept));
            accept.click();
            assertEquals(mainPage.getCityText(), "Алматы");
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/");
        });
    }

}

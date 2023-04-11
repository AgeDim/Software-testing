
import org.example.driver.BrowserDrivers;
import org.example.gesm.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import java.io.IOException;
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

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @DisplayName("News button click test")
    public void NewsButtonClickTest() {
        mainPageMap.forEach((key, mainPage) -> {
            mainPage.NewsBtnClick();
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/news/");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @DisplayName("Maps button click test")
    public void MapsButtonClickTest() {
        mainPageMap.forEach((key, mainPage) -> {
            mainPage.MapsBtnClick();
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/maps/");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @DisplayName("Informs button click test")
    public void InformButtonClickTest() {
        mainPageMap.forEach((key, mainPage) -> {
            mainPage.InformsBtnClick();
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/informers/");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @DisplayName("Apps button click test")
    public void AppsButtonClickTest() {
        mainPageMap.forEach((key, mainPage) -> {
            mainPage.AppsBtnClick();
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/soft/");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @DisplayName("Search city weather test")
    public void SearchInputTest() {
        mainPageMap.forEach((key, mainPage) -> {
            try {
                mainPage.SearchInputClick("Алматы");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/weather-almaty-5205/");
        });
    }

    @Test
    @DisplayName("Switch city weather test")
    public void EditCityButtonClickTest() {
        mainPageMap.forEach((key, mainPage) -> {
            try {
                mainPage.EditCityBtnClick();
                WebElement input = mainPage.getWebDriver().findElement(By.xpath(
                        "/html/body/section/div/section/form/div/label[3]/span/span[2]/span/input"));
                input.sendKeys("Алматы");
                TimeUnit.SECONDS.sleep(2);
                mainPage.getWebDriver().findElement(By.xpath(
                        "/html/body/section/div/section/form/div/label[3]/span/span[2]/div/div/div[2]/div[1]")
                ).click();
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            assertEquals(mainPage.getCityText(), "Алматы");
            assertEquals(mainPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/");
        });
    }

}

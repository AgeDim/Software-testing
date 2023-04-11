import org.example.driver.BrowserDrivers;
import org.example.gesm.MapPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapPageTest {
    static BrowserDrivers browserDrivers;
    static HashMap<String, MapPage> mapPageMap;


    @BeforeEach
    public void setUp() throws IOException {
        browserDrivers = new BrowserDrivers();
        mapPageMap = new HashMap<>();
        browserDrivers.getDrivers().forEach((key, driver) -> driver.get("https://www.gismeteo.ru/maps/"));
        browserDrivers.getDrivers().forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.getDrivers().forEach((key, driver) -> mapPageMap.put(key, new MapPage(driver)));
        browserDrivers.getDrivers().forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }


    @AfterEach
    public void closeWindow() {
        browserDrivers.closeBrowser();
    }

    @Test
    @DisplayName("Temp button click test")
    public void TempButtonClickTest() {
        mapPageMap.forEach((key, mapPage) -> {
            mapPage.TempBtnClick();
            assertEquals(mapPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/maps/eur/temp/");
        });
    }

    @Test
    @DisplayName("Wind button click test")
    public void WindButtonClickTest() {
        mapPageMap.forEach((key, mapPage) -> {
            mapPage.WindBtnClick();
            assertEquals(mapPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/maps/eur/wind/");
        });
    }

    @Test
    @DisplayName("Cloud button click test")
    public void CloudButtonClickTest() {
        mapPageMap.forEach((key, mapPage) -> {
            mapPage.CloudBtnClick();
            assertEquals(mapPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/maps/eur/clou/");
        });
    }


    @Test
    @DisplayName("Allergy button click test")
    public void AllergyButtonClickTest() {
        mapPageMap.forEach((key, mapPage) -> {
            mapPage.AllergyBtnClick();
            assertEquals(mapPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/maps/allergy/");
        });
    }

    @Test
    @DisplayName("Select Dalniy Vostok test")
    public void SelectRegion1Test() {
        mapPageMap.forEach((key, mapPage) -> {
            mapPage.selectRegion(1);
            assertEquals(mapPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/maps/feru/prc/");
        });
    }

    @Test
    @DisplayName("Select Sibir test")
    public void SelectRegion2Test() {
        mapPageMap.forEach((key, mapPage) -> {
            mapPage.selectRegion(0);
            assertEquals(mapPage.getWebDriver().getCurrentUrl(), "https://www.gismeteo.ru/maps/sib/prc/");
        });
    }

}

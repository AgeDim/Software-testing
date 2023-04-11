package org.example.gesm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPage {

    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/header/div[1]/div/div/div[3]/div/a[1]")
    private WebElement NewsBtn;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/div[1]/div/input")
    private WebElement searchInput;
    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div[2]/div/a[1]")
    private WebElement SubNavNow;
    @FindBy(xpath = "/html/body/header/div[1]/div/div/div[3]/div/a[2]")
    private WebElement MapsBtn;
    @FindBy(xpath = "/html/body/section/div[1]/section[1]/div[1]/div/div[1]/a[2]")
    private WebElement EditCityBtn;

    @FindBy(xpath = "/html/body/header/div[1]/div/div/div[3]/div/a[3]")
    private WebElement InformsBtn;

    @FindBy(xpath = "/html/body/header/div[1]/div/div/div[3]/div/a[4]")
    private WebElement AppsBtn;

    @FindBy(xpath = "/html/body/section/div[1]/section[1]/div[1]/div/div[1]/a[1]")
    private WebElement CityText;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/div[2]/div/div[2]/a[1]")
    private WebElement FirstEqualsValue;


    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void NewsBtnClick(){
        NewsBtn.click();
    }

    public void MapsBtnClick(){
        MapsBtn.click();
    }

    public void InformsBtnClick(){
        InformsBtn.click();
    }

    public void AppsBtnClick(){
        AppsBtn.click();
    }

    public String getCityText(){
        return CityText.getText();
    }

    public void EditCityBtnClick(){
        EditCityBtn.click();
    }

    public void SearchInputClick(String name){
        searchInput.sendKeys(name);
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(FirstEqualsValue));
        FirstEqualsValue.click();
    }


}

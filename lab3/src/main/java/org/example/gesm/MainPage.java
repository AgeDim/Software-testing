package org.example.gesm;

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

    @FindBy(xpath = "//a[@href='/news/']")
    private WebElement NewsBtn;

    @FindBy(xpath = "//input")
    private WebElement searchInput;
    //a[@href='/weather-almaty-5205/']
    @FindBy(xpath = "//a[@href='/maps/']")
    private WebElement MapsBtn;
    @FindBy(xpath = "//a[@href='/current-location']")
    private WebElement EditCityBtn;

    @FindBy(xpath = "//a[@href='/informers/']")
    private WebElement InformsBtn;

    @FindBy(xpath = "//a[@href='/soft/']")
    private WebElement AppsBtn;

    @FindBy(xpath = "//a[@class='city-link link']")
    private WebElement CityText;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/div[2]/div/div[2]/a[1]")
    private WebElement FirstEqualsValue;


    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void NewsBtnClick() {
        NewsBtn.click();
    }

    public void MapsBtnClick() {
        MapsBtn.click();
    }

    public void InformsBtnClick() {
        InformsBtn.click();
    }

    public void AppsBtnClick() {
        AppsBtn.click();
    }

    public String getCityText() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(CityText));
        return CityText.getText();
    }

    public void EditCityBtnClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(EditCityBtn));
        EditCityBtn.click();
    }

    public void SearchInputClick(String name) {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.sendKeys(name);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(FirstEqualsValue));
        FirstEqualsValue.click();
    }


}

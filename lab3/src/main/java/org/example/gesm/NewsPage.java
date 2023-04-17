package org.example.gesm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class NewsPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "//a[@href='/news/auto/']")
    private WebElement AutoBtn;

    @FindBy(xpath = "//a[@href='/news/science/']")
    private WebElement ScienceBtn;

    @FindBy(xpath = "//a[@href='/news/nature/']")
    private WebElement NatureBtn;

    @FindBy(xpath = "//a[@href='/news/coronavirus/']")
    private WebElement CovidBtn;

    @FindBy(xpath = "//a[@href='/news/animals/']")
    private WebElement AnimalBtn;

    @FindBy(xpath = "//a[@href='/news/weather/']")
    private WebElement WeatherBtn;

    public NewsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void AutoBtnClick() {
        AutoBtn.click();
    }

    public void ScienceBtnClick() {
        ScienceBtn.click();
    }

    public void NatureBtnClick() {
        NatureBtn.click();
    }

    public void CovidBtnClick() {
        CovidBtn.click();
    }

    public void AnimalBtnClick() {
        AnimalBtn.click();
    }

    public void WeatherBtnClick() {
        WeatherBtn.click();
    }

}

package org.example.gesm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class NewsPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/a[1]")
    private WebElement AutoBtn;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/a[2]")
    private WebElement ScienceBtn;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/a[3]")
    private WebElement NatureBtn;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/a[4]")
    private WebElement CovidBtn;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/a[5]")
    private WebElement AnimalBtn;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/a[6]")
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

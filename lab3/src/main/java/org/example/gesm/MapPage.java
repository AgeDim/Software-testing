package org.example.gesm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MapPage {

    private final WebDriver webDriver;

    @FindBy(xpath = "//a[@href='/maps/eur/temp/']")
    private WebElement TempBtn;

    @FindBy(xpath = "//a[@href='/maps/eur/wind/']")
    private WebElement WindBtn;

    @FindBy(xpath = "//a[@href='/maps/eur/clou/']")
    private WebElement CloudBtn;

    @FindBy(xpath = "//a[@href='/maps/allergy/']")
    private WebElement AllergyBtn;

    public MapPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void selectRegion(Integer index) {

        webDriver.findElement(By.xpath("//div[@aria-controls='dropdown-menu-map']")).click();
        List<WebElement> elements = webDriver.findElements(By.xpath("/html/body/header/div[2]/div[2]/div/div/div[2]/a"));
        elements.get(index).click();
    }

    public void AllergyBtnClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(AllergyBtn));
        AllergyBtn.click();
    }

    public void CloudBtnClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(CloudBtn));
        CloudBtn.click();
    }

    public void WindBtnClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(WindBtn));
        WindBtn.click();
    }

    public void TempBtnClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(TempBtn));
        TempBtn.click();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}

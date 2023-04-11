package org.example.gesm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MapPage {

    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/a[1]")
    private WebElement TempBtn;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/a[2]")
    private WebElement WindBtn;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/a[3]")
    private WebElement CloudBtn;

    @FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div/a[4]")
    private WebElement AllergyBtn;

    public MapPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void selectRegion(Integer index){
        webDriver.findElement(By.xpath("/html/body/header/div[2]/div[2]/div/div/div[1]")).click();
        List<WebElement> elements = webDriver.findElements(By.xpath("/html/body/header/div[2]/div[2]/div/div/div[2]/a"));
        elements.get(index).click();
    }
    public void AllergyBtnClick() {
        AllergyBtn.click();
    }

    public void CloudBtnClick() {
        CloudBtn.click();
    }

    public void WindBtnClick() {
        WindBtn.click();
    }
    public void TempBtnClick() {
        TempBtn.click();
    }
    public WebDriver getWebDriver() {
        return webDriver;
    }
}

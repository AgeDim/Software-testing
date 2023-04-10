package org.example.driver;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

public class BrowserDrivers {
    HashMap<String, WebDriver> drivers = new HashMap<>();

    public BrowserDrivers() throws IOException {
        final String filePath = "C:\\Users\\Дмитрий\\IdeaProjects\\Software-testing\\lab3\\Driver.json";

        HashMap<String,String> driverPatchs = new ObjectMapper().readValue(new String(Files.readAllBytes(Paths.get(filePath))), HashMap.class);

        String chromeDriver = "webdriver.chrome.driver";
        if (!Objects.equals(driverPatchs.get("Chrome"), "")) {
            System.setProperty(chromeDriver, driverPatchs.get("Chrome"));
            this.drivers.put("Chrome", new ChromeDriver());
        }

        String firefoxDriver = "webdriver.gecko.driver";
        if (!Objects.equals(driverPatchs.get("Firefox"), "")){
            System.setProperty(firefoxDriver, driverPatchs.get("Firefox"));
            this.drivers.put("Firefox", new FirefoxDriver());
        }

        String chromiumDriver = "webdriver.chromium.driver";
        if (!Objects.equals(driverPatchs.get("Chromium"), "")) {
            System.setProperty(chromiumDriver, driverPatchs.get("Chromium"));
            this.drivers.put("Chromium", new EdgeDriver());
        }

        String internetExplorerDriver = "webdriver.InternetExplorer.driver";
        if (!Objects.equals(driverPatchs.get("InternetExplorer"), "")) {
            System.setProperty(internetExplorerDriver, driverPatchs.get("InternetExplorer"));
            this.drivers.put("InternetExplorer",new InternetExplorerDriver());
        }

        String operaDriver = "webdriver.opera.driver";
        if (!Objects.equals(driverPatchs.get("Opera"), "")) {
            System.setProperty(operaDriver, driverPatchs.get("Opera"));
            ChromeOptions options = new ChromeOptions();
            options.setBinary("");
            this.drivers.put("Opera", new ChromeDriver(options) );
        }

        String safariDriver = "webdriver.safari.driver";
        if (!Objects.equals(driverPatchs.get("Safari"), "")) {
            System.setProperty(safariDriver, driverPatchs.get("Safari"));
            this.drivers.put("Safari", new SafariDriver());
        }


    }

    public HashMap<String, WebDriver> getDrivers()
    {
        return this.drivers;
    }

    public void closeBrowser()
    {
        for (String key : this.drivers.keySet()) {
            drivers.get(key).close();
        }
    }
}
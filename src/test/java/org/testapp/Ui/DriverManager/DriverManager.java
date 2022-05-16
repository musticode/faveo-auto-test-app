package org.testapp.Ui.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testapp.Ui.DriverManager.Selenoid.CapabilityFactorySelenoid;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public static WebDriver driver;
    public DriverOptions driverOptions;
    CapabilityFactorySelenoid capabilityFactorySelenoid = new CapabilityFactorySelenoid();
    public RemoteWebDriver remoteWebDriver;


    public void getDriver(String browserName) throws MalformedURLException {
        driverOptions = new DriverOptions();

        switch (browserName){
            case "chrome-local":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(driverOptions.getChromeOptions());
                break;

            case "firefox-local":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(driverOptions.getFirefoxOptions());
                break;

            case "opera-local":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;

            case "chrome-grid":
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),driverOptions.getChromeOptions());
                break;

            case "firefox-grid":
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), driverOptions.getFirefoxOptions());
                break;

            case "opera-grid":
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),driverOptions.getOperaOptions());
                break;

            case "chrome-selenoid":
                remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                        capabilityFactorySelenoid.getSelenoidCapability("chrome"));
                break;

            case "firefox-selenoid":
                remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                        capabilityFactorySelenoid.getSelenoidCapability("firefox"));
                break;

            case "firefox-opera":
                remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                        capabilityFactorySelenoid.getSelenoidCapability("opera"));
                break;

            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox-headless":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions2 = new FirefoxOptions();
                firefoxOptions2.setHeadless(true);
                driver = new FirefoxDriver(firefoxOptions2);
                break;

            case "jenkins-chrome":
                driver = new RemoteWebDriver(new URL("http://172.17.0.2:4444/wd/hub"),driverOptions.getJenkinsChromeOptions());
                break;

        }
    }


    public void tearDown(){
        if(driver != null ){
            driver.quit();
        }
    }

}

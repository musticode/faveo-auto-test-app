package org.testapp.Ui.Test.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testapp.Ui.DriverManager.DriverManager;
import org.testapp.Ui.DriverManager.DriverOptions;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class ThreadLocalBaseTestFactory {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public DriverOptions driverOptions = new DriverOptions();
    protected static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();


    @BeforeMethod
    @Parameters(value={"browserName"})
    public void setup (@Optional String browserName) throws MalformedURLException {
        //Set Browser to ThreadLocalMap
        //driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), driverOptions.getFirefoxOptions()));


        if (browserName == null){
            WebDriverManager.chromedriver().setup();
            localDriver.set(new ChromeDriver());
        }

//        if (browserName.equals("firefox-grid")){
//            driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), driverOptions.getFirefoxOptions()));
//        }else if (browserName.equals("chrome-grid")){
//            driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), driverOptions.getChromeOptions()));
//        }else if (browserName.equals("opera-grid")){
//            driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), driverOptions.getOperaOptions()));
//        }

    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap

        return localDriver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }


    @AfterClass
    void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }





}

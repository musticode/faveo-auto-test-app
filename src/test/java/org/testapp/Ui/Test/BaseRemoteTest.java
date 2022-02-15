package org.testapp.Ui.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testapp.Ui.DriverManager.DriverOptions;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseRemoteTest {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public static DriverOptions driverOptions = new DriverOptions();

    //@BeforeMethod
    @BeforeClass
    public void setup () throws MalformedURLException {

        //Set Browser to ThreadLocalMap
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),driverOptions.getFirefoxOptions()));
    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }
//    @AfterMethod
    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }
//    @AfterClass
    @AfterTest
    void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }



}

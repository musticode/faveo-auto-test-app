package org.testapp.Ui.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testapp.Ui.DriverManager.DriverOptions;
import org.testapp.Ui.DriverManager.Selenoid.CapabilityFactorySelenoid;
import org.testapp.Ui.Pages.DemoQAPages.DemoPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testapp.Ui.Test.TestBase.BaseTestSelenoid;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestWithSelenoid{
    protected static /*ThreadLocal<RemoteWebDriver> */ RemoteWebDriver remoteDriver; /*= new ThreadLocal<>();*/

    public WebDriver driver;
    DemoPage demoPage;
    public DriverOptions driverOptions = new DriverOptions();
    CapabilityFactorySelenoid capabilityFactorySelenoid;
    /* = new CapabilityFactorySelenoid();*/

    @BeforeMethod
    public void initiallizeBrowser() throws Exception {
        capabilityFactorySelenoid = new CapabilityFactorySelenoid();
//        remoteDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap.getSelenoidCapability("chrome")));
        remoteDriver = new RemoteWebDriver(new URL("http://selenoid:4444/wd/hub"), capabilityFactorySelenoid.getSelenoidCapability("chrome"));

    }
    public WebDriver getDriver(){
//        return remoteDriver.get();
        return null;
    }
    @AfterMethod
    public void tearDown() throws Exception {
//        getDriver().quit();
        driver.quit();
    }
    @AfterTest
    public void terminate() throws Exception {
//        remoteDriver.remove();
    }






    @Test
    void test1() throws MalformedURLException {
        remoteDriver.get("https://www.google.com/");
    }



}

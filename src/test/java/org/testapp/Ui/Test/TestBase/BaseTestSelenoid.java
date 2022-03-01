package org.testapp.Ui.Test.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testapp.Ui.DriverManager.Selenoid.CapabilityFactorySelenoid;
import org.testng.annotations.*;

import java.net.URL;

public class BaseTestSelenoid {
//    protected static ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<>();

    public RemoteWebDriver remoteWebDriver;

    CapabilityFactorySelenoid capabilityFactorySelenoid = new CapabilityFactorySelenoid();


    @BeforeMethod
    @Parameters(value = "browser")
    public void initiallizeBrowser(@Optional  String browser) throws Exception {
//        remoteDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilityFactorySelenoid.getSelenoidCapability(browser)));


//        remoteDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilityFactorySelenoid.getSelenoidCapability("chrome")));


        remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                capabilityFactorySelenoid.getSelenoidCapability("chrome"));


    }
/*    public WebDriver getDriver(){
        return remoteDriver.get();
    }*/

    @AfterMethod
    public void tearDown() throws Exception {
        remoteWebDriver.quit();
    }
    @AfterTest
    public void terminate() throws Exception {
//        remoteWebDriver.remove();
    }


}

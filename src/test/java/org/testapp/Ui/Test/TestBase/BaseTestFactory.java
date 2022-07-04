package org.testapp.Ui.Test.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testapp.Ui.DriverManager.DriverManager;
import org.testapp.Ui.DriverManager.DriverOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTestFactory extends DriverManager {

    @BeforeTest
    @Parameters(value = {"browserName"} )
    public void initializeBrowser(@Optional String browserName) throws MalformedURLException {

        //getDriver("chrome-headless");
        //a
//        getDriver(browserName);

        if(browserName == null){
            getDriver("firefox-grid");
            System.out.println("Grid firefox is opened");
            driver.manage().window().maximize();
        }else{
            getDriver(browserName);
            System.out.println("Browser is opened: "+ browserName);
        }
    }


    @AfterTest
    public void terminateBrowser(){
        tearDown();
        driver.close();
        System.out.println("Driver is removed");
    }

}

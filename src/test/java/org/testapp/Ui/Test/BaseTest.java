package org.testapp.Ui.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testapp.Ui.DriverManager.DriverOptions;
import org.testng.annotations.*;

public class BaseTest{
    public static WebDriver driver;
    public static DriverOptions driverOptions;


    @BeforeClass
    public void setUp(){
        driverOptions = new DriverOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(driverOptions.getChromeOptions());
        System.out.println("Driver is initialized");
    }


    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
            System.out.println("Driver is removed");
        }
    }


}

package org.testapp.Ui.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testapp.Ui.DriverManager.DriverOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest{
    public static WebDriver driver;
    public static DriverOptions driverOptions;

    @BeforeTest
    public void setUp(){
        driverOptions = new DriverOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(driverOptions.getChromeOptions());
        driver.manage().window().maximize();
    }
    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }


}

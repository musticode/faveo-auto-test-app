package org.testapp.Ui.Pages.TotalNocSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.DriverManager.DriverManager;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor javascriptExecutor;

    String APP_URL = PropertyManager.getInstance().getAppUrl();

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    public <T> WebElement findElement(T elementAttr){
        if (elementAttr.getClass().getName().contains("By")){
            return driver.findElement((By) elementAttr);
        }else{
            return ((WebElement) elementAttr);
        }
    }

    public <T> void waitElement(T elementAttr){
        if (elementAttr.getClass().getName().contains("By")){
            wait.until(ExpectedConditions.elementToBeClickable((By) elementAttr));
        }else{
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));
        }
    }

    public <T> void click(T elementAttr){
        waitElement(elementAttr);
        findElement(elementAttr).click();
    }

    public <T> void setText(T elementAttr, String text){
        waitElement(elementAttr);
        findElement(elementAttr).sendKeys(text);
    }

    public <T> String getText(T elementAttr){
        waitElement(elementAttr);
        return findElement(elementAttr).getText();
    }

    public <T> boolean isDisplayed(T elementAttr){
        waitElement(elementAttr);
        return findElement(elementAttr).isDisplayed();
    }




}

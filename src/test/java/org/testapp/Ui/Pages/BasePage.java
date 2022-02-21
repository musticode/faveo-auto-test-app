package org.testapp.Ui.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testapp.Ui.DataProvider.PropertyManager;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public String APP_URL = PropertyManager.getInstance().getAppUrl();

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }
    public void waitForLocator(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement findBy(By locator){
        return driver.findElement(locator);
    }
    public void click(By locator){
        waitForLocator(locator);
        findBy(locator).click();
    }
    public void setText(By locator, String text){
        waitForLocator(locator);
        findBy(locator).sendKeys(text);
    }
    public String getText(By locator){
        waitForLocator(locator);
        return findBy(locator).getText();
    }
    public boolean isDisplayed(By locator){
        waitForLocator(locator);
        return findBy(locator).isDisplayed();
    }

    public <T> void clickGeneric(T elementAttr){
        if(elementAttr.getClass().getName().contains("By")){
            waitForGeneric(elementAttr);
            driver.findElement((By)elementAttr).click();
        }else{
            waitForGeneric(elementAttr);
            ((WebElement)elementAttr).click();
        }
    }
    public <T> void waitForGeneric(T elementAttr){
        if(elementAttr.getClass().getName().contains("By")){
            wait.until(ExpectedConditions.elementToBeClickable((By) elementAttr));
        }else{
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));
        }
    }
    public <T> void setTextGeneric(T elementAttr, String text){
        if(elementAttr.getClass().getName().contains("By")){
            waitForGeneric(elementAttr);
            driver.findElement((By)elementAttr).sendKeys(text);
        }else{
            waitForGeneric(elementAttr);
            ((WebElement)elementAttr).sendKeys(text);
        }
    }

    public <T> boolean isDisplayedGeneric(T elementAttr){
        if(elementAttr.getClass().getName().contains("By")){
            waitForGeneric(elementAttr);
            return driver.findElement((By)elementAttr).isDisplayed();
        }else{
            waitForGeneric(elementAttr);
            return ((WebElement)elementAttr).isDisplayed();
        }
    }



}

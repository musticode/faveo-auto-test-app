package org.testapp.Ui.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testapp.Ui.DataProvider.PropertyManager;

import java.util.List;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public String APP_URL = PropertyManager.getInstance().getAppUrl();
    public Long WAIT = PropertyManager.getInstance().getWait();

    JavascriptExecutor js;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT);
        js = (JavascriptExecutor)driver;
    }

    public void waitForLocator(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findBy(By locator){
        return driver.findElement(locator);
    }

    public void getPage(String pagePath){
        if (pagePath != null){
            driver.get(APP_URL.concat(pagePath));
        }else{
            driver.get(APP_URL);
        }
    }

    public void alertAccept(){
        driver.switchTo().alert().accept();
    }

    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void click(By locator){
        waitForLocator(locator);
        findBy(locator).click();
    }

    public void setText(By locator, String text){
        waitForLocator(locator);
        findBy(locator).clear();
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

    //scroll functions
    public void scrollDown(){
        js.executeScript("window.scrollBy(0,600)");
    }

    public void scrollUp(){
        js.executeScript("window.scrollBy(0, -500)");
    }

    public void scrollDownByValue(int value){
        String script = "window.scrollBy(0,"+ value + ")";
        js.executeScript(script);
    }

    public void scrollDownDoc(){
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }



    Select selectGeneric;
    public <T> void select(By locator, T selected ){
        selectGeneric = new Select(findBy(locator));

        if (selected.getClass().getName().equalsIgnoreCase("String")){
            selectGeneric.selectByValue((String) selected);
        }else if(selected.getClass().getName().equalsIgnoreCase("integer")){
            selectGeneric.selectByIndex((Integer)selected);
        }
    }











    //generic methods
    public <T> WebElement getElement(T elementAttr){
        if(elementAttr.getClass().getName().contains("By")){
            return driver.findElement((By) elementAttr);
        }else{
            return ((WebElement) elementAttr);
        }
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

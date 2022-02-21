package org.testapp.Ui.Pages.Faveo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private final String FAVEO_URL = "https://sprint9stag1msp.osticket.dmdemo.comodo.com";

    private By emailTextAreaLocator = By.cssSelector("#staff-login > div > form > div:nth-child(2) > input");
    private By passwordTextAreaLocator = By.cssSelector("#staff-login > div > form > div:nth-child(5) > input");
    private By loginButtonLocator = By.cssSelector("#staff-login > div > form > div:nth-child(6) > button");

    private By clientLoginTabLocator = By.id("client-login-tab");
    private By staffLoginTabLocator = By.id("staff-login-tab");

    private By alertEmailNotRegisteredLocator = By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[1]");

    @FindBy (id = "staff-login-tab")
    WebElement stafEl;


    private HomePage homePage;
    private DashboardPage dashboardPage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

        driver.get(APP_URL.concat("/auth/login"));
        driver.manage().deleteAllCookies();
    }
    @Step("Navigate to login page")
    public void getLoginPage(){
        driver.get(APP_URL.concat("/auth/login"));
        driver.manage().deleteAllCookies();
    }
    public void clickelTest(){
        clickGeneric(stafEl);
    }



    @Step("Client login with email {email} and password {pwd}")
    public void clientlogin(String email, String pwd){
        click(clientLoginTabLocator);
        setText(emailTextAreaLocator, email);
        setText(passwordTextAreaLocator, pwd);
        click(loginButtonLocator);
    }

    @Step("Staff login with email {email} and password {pwd}")
    public void staffLogin(String email, String pwd){
        click(staffLoginTabLocator);
        setText(emailTextAreaLocator, email);
        setText(passwordTextAreaLocator, pwd);
        click(loginButtonLocator);
    }


    public boolean isAlertSeenAfterInvalidLogin(){
        return isDisplayed(alertEmailNotRegisteredLocator);
    }



    public HomePage getHomepage(){
        return homePage = new HomePage(driver);
    }
    public DashboardPage getDashboardPage(){
        return dashboardPage = new DashboardPage(driver);
    }
    public void checkLoginPageOpened(){
        Assert.assertEquals(isDisplayed(staffLoginTabLocator), true, "Login page is not opened");
    }




}

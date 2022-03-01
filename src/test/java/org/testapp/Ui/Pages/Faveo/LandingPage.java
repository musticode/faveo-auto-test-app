package org.testapp.Ui.Pages.Faveo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;

public class LandingPage extends BasePage {

    @FindBy 

    private By loginNavigateButton = By.xpath("//*[@id=\"wbox\"]/span[1]/a");
    private By registerNavigateButton = By.xpath("//*[@id=\"wbox\"]/span[2]/a");
    private By submitTicketNavigateLocator = By.xpath("//*[@id=\"wbox\"]/span[3]/a");


    
    
    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void getLandingPage(){
        driver.get(APP_URL);
    }
    public LandingPage getLanding(){
        driver.get(APP_URL);
        return this;
    }



    private LoginPage loginPage;
    private RegisterPage registerPage;
    private SubmitTicketPage submitTicketPage;

    @FindBy(xpath = "//a[contains(@style, 'news')]")
    public WebElement myTicketsElement;

    @FindBy(xpath = "//a[contains(@style, 'knowledgebase')]")
    public WebElement knowledgeBaseElement;

    public LoginPage getLoginPageWithButton(){
        click(loginNavigateButton);
        return new LoginPage(driver);
    }

    public void navigateTo(String pageName){
        if(pageName.equalsIgnoreCase("login")){
            click(loginNavigateButton);
            loginPage = new LoginPage(driver);
        }else if (pageName.equalsIgnoreCase("register")){
            click(registerNavigateButton);
            registerPage = new RegisterPage(driver);
        }else if(pageName.equalsIgnoreCase("submitTicket")){
            click(submitTicketNavigateLocator);
            submitTicketPage = new SubmitTicketPage(driver);
        }
    }

    @Step("Click my tickets in landing page")
    public LoginPage clickMytickets(){
        clickGeneric(myTicketsElement);
        return new LoginPage(driver);

    }

    @Step("Click knowledge base in landing page")
    public LoginPage getKnowledgeBase(){
        clickGeneric(knowledgeBaseElement);
        return new LoginPage(driver);
    }



    public LoginPage getLoginPage(){
        click(loginNavigateButton);

        if(loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
}

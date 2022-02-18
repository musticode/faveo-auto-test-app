package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class LandingPage extends BasePage {

    private By loginNavigateButton = By.xpath("//*[@id=\"wbox\"]/span[1]/a");
    private By registerNavigateButton = By.xpath("//*[@id=\"wbox\"]/span[2]/a");
    private By submitTicketNavigateLocator = By.xpath("//*[@id=\"wbox\"]/span[3]/a");


    public LandingPage(WebDriver driver) {
        super(driver);
    }
    public void getLandingPage(){
        driver.get(APP_URL);
    }
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private SubmitTicketPage submitTicketPage;

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



    public LoginPage getLoginPage(){
        click(loginNavigateButton);

        if(loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
}

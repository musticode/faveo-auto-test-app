package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class LandingPage extends BasePage {
    private final String FAVEO_URL = "https://sprint9stag1msp.osticket.dmdemo.comodo.com";

    private By emailTextAreaLocator = By.cssSelector("input[placeholder='Email']");
    private By passwordTextAreaLocator = By.cssSelector("input[placeholder='Password']");
    private By loginButtonLocator = By.cssSelector("button[class='btn btn-primary btn-block btn-flat']");

    private HomePage homePage;
    public LandingPage(WebDriver driver) {
        super(driver);
        driver.get(FAVEO_URL.concat("/auth/login"));
    }
    public void login(String email, String pwd){
        setText(emailTextAreaLocator, email);
        setText(passwordTextAreaLocator, pwd);
        click(loginButtonLocator);
    }

    public HomePage getHomepage(){
        return homePage = new HomePage(driver);
    }




}

package org.testapp.Ui.Pages.Sdv2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.TotalNocSupport.BasePage;

public class Sdv2LoginPage extends BasePage {

    String loginPageUrl = "https://testaccount21nov.servicedeskv2.dmdemo.comodo.com/auth/login";

    @FindBy(id = "staff-login-tab")
    WebElement staffLoginTab;

    @FindBy(css = "form[action='https://staging.one.comodo.com/app/sso/auth'] input[type='text']")
    public WebElement emailInput2;

    @FindBy(css = "form[action='https://staging.one.comodo.com/app/sso/auth'] input[name='password']")
    public WebElement passwordInput2;

    @FindBy(css = "form[action='https://staging.one.comodo.com/app/sso/auth'] button")
    public WebElement btnButton2;
    
    public Sdv2LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getLoginPage(){
        driver.get(loginPageUrl);
    }

    public void staffLogin(String email, String password){
        click(staffLoginTab);
        setText(emailInput2, email);
        setText(passwordInput2, password);
        click(btnButton2);
    }





}

package org.testapp.Ui.Pages.Pair;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testapp.Ui.Pages.BasePage;
import org.testng.annotations.Test;

import java.util.Set;

public class LoginPage extends BasePage {

    private By loginWith0465Locator = By.xpath("//a[normalize-space()='Login With O365 Account']");
    private By emailTextAreaLocator = By.xpath("//input[@id='i0116']");
    private By nextButtonEmailModal = By.xpath("//input[@id='idSIButton9']");
    private By passwordLocator = By.xpath("//input[@id='i0118']");
    private By submitButtonLocator = By.xpath("//input[@id='idSIButton9']");
    private By submitYesButtonLocator = By.xpath("//input[@id='idSIButton9']");

    //ringcentral
    private By ringCentralLoginButtonLocator = By.xpath("//*[@id=\"viewport\"]/div/div/button");
    private By emailOrPhoneNumberTextLocator = By.xpath("//input[@id='credential']");
    private By emailNextButtonLocator = By.xpath("//button[normalize-space()='Next']");
    private By rcPasswordTextLocator = By.xpath("//input[@id='password']");
    private By rcPasswordSignInButtonLocator = By.xpath("//button[normalize-space()='Sign In']");
    private By authorizeButtonLocator = By.xpath("//button[normalize-space()='Authorize']");
    private By acceptButtonLocator = By.xpath("//button[normalize-space()='I Accept']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void getLoginPage(){
        driver.get("https://overlay-test.ctrl.comodo.com/login");
    }

    public void login(String email, String password){
        click(loginWith0465Locator);
        setText(emailTextAreaLocator, email);
        click(nextButtonEmailModal);
        setText(passwordLocator, password);
        click(submitButtonLocator);
        click(submitYesButtonLocator);
    }

    //String parentWindow = driver.getWindowHandle();

    public void ringCentralLogin(String username, String password){ //rc overlaytest2@numsp.com - password: S3qr6y*^
        String parentWindow = driver.getWindowHandle();

        driver.switchTo().frame("rc-widget-adapter-frame");

        click(ringCentralLoginButtonLocator);


        click(ringCentralLoginButtonLocator);

        //rc modal opened
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows){
            System.out.println("rc modal window handle: "+window);

            if (!window.equals(parentWindow)){ //2.window
                driver.switchTo().window(window);
                //element actions
                setText(emailOrPhoneNumberTextLocator, username);
                click(emailNextButtonLocator);
                setText(rcPasswordTextLocator, password);
                click(rcPasswordSignInButtonLocator);
                scrollDown();
                //click authorize
                click(authorizeButtonLocator);
                click(acceptButtonLocator);
            }

        }




    }

        public void ringCentralLoginIframe(String username, String password){
            driver.switchTo().frame("rc-widget-adapter-frame");
            //driver.manage().window().maximize();

            click(ringCentralLoginButtonLocator);



            String text = getText(By.xpath("//label[normalize-space()='Email or Phone Number']"));
            System.out.println(text);


            setText(emailOrPhoneNumberTextLocator, username);
            click(emailNextButtonLocator);
            setText(rcPasswordTextLocator, password);
            click(rcPasswordSignInButtonLocator);
            scrollDown();
            //click authorize
            click(authorizeButtonLocator);
            click(acceptButtonLocator);

    }




}

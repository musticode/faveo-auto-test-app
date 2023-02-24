package org.testapp.Ui.Pages.TotalNocSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;



public class TnsMainPage extends BasePage {
    private final String TNS_MAIN_URL = "https://staging-cloudmsp.ctrl.comodo.com/";



    private By signInXpathLocator = By.xpath("//a[contains(.,'Sign In')]");
    private By emailTextFieldLocator = By.xpath("//input[contains(@type,'text')]");
    private By passwordTextFieldXpathLocator = By.xpath("//input[contains(@type,'password')]");
    private By signInButtonLocator = By.xpath("//span[contains(.,'Sign in')]");



    public TnsMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getMainPage(){
        driver.get(TNS_MAIN_URL);
    }

    public void login(String userName, String password){
        click(signInXpathLocator);
        setText(emailTextFieldLocator, userName);
        setText(passwordTextFieldXpathLocator, password);
        click(signInButtonLocator);
    }

    public boolean isMainPageDisplayed(){
        return isDisplayed(signInButtonLocator);
    }


}

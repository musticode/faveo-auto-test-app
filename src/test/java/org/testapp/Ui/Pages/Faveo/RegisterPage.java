package org.testapp.Ui.Pages.Faveo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;
import org.testng.Assert;

public class RegisterPage extends BasePage {
    private By registrationH3TextLocator = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/h3");

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Step("Get register page")
    public void getRegisterPage(){
        driver.get(APP_URL.concat("/auth/register"));
    }

    public void checkRegistrationPageOpened(){
        Assert.assertEquals(getText(registrationH3TextLocator), "Registration", "Registration page is not opened");
    }
}

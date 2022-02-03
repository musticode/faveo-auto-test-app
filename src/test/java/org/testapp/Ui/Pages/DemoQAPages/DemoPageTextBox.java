package org.testapp.Ui.Pages.DemoQAPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class DemoPageTextBox extends BasePage {
    private final String DEMO_TEXT_BOX_PAGE_URL ="https://demoqa.com/text-box";

    private By fullNameLocator = By.id("userName");
    private By emailLocator = By.id("userEmail");
    private By currentAddressLocator = By.id("currentAddress");
    private By parmanentAddressLocator = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By outputAreaLocator = By.id("output");

    public DemoPageTextBox(WebDriver driver) {
        super(driver);
        driver.get(DEMO_TEXT_BOX_PAGE_URL);
    }

    @Step("filling text box with fullname {0} email {1} current address {2} parmanent address {3}")
    public void fillTextBox(String fullName, String email, String currentAddress, String parmanentAddress){
        setText(fullNameLocator, fullName);
        setText(emailLocator, email);
        setText(currentAddressLocator, currentAddress);
        setText(parmanentAddressLocator, parmanentAddress);
        //click(submitButton);
    }
    @Step("click submit button")
    public void submit(){
        click(submitButton);
    }
    public String getOutput(){
        return getText(outputAreaLocator);
    }
    public void isOutputTrue(){

    }


}

package org.testapp.Ui.Pages.DemoQAPages;

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

    public void fillTextBox(String fullName, String email, String currentAddress, String parmanentAddress){
        setText(fullNameLocator, fullName);
        setText(emailLocator, email);
        setText(currentAddressLocator, currentAddress);
        setText(parmanentAddressLocator, parmanentAddress);
        //click(submitButton);
    }
    public void submit(){
        click(submitButton);
    }
    public String getOutput(){
        return getText(outputAreaLocator);
    }
    public void isOutputTrue(){

    }


}

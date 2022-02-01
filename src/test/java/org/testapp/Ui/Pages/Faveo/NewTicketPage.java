package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class NewTicketPage extends BasePage {

    private By emailLocator = By.id("email");
    private By firstNameLocator = By.id("first_name");
    private By lastNameLocator = By.id("last_name");
    private By countryCodeLocator = By.id("country_code");
    private By mobileLocator = By.id("mobile");
    private By phoneLocator = By.id("phone_number");

    private By subjectTextAreaLocator = By.cssSelector("input[name='subject']");
    private By detailTextAreaLocator = By.cssSelector("div[role='textbox']");

    private By createTicketButtonLocator = By.cssSelector("input[value='Create ticket']");

    public NewTicketPage(WebDriver driver) {
        super(driver);
    }
    public void getTicketCreate(){
        driver.get(APP_URL.concat("/newticket"));
    }

    public void fillUserDetails(String email, String firstName, String lastName, String code, String mobileNumber, String phone){
        setText(emailLocator, email);
        setText(firstNameLocator, firstName);
        setText(lastNameLocator, lastName);
        setText(countryCodeLocator, code);
        setText(mobileLocator, mobileNumber);
        setText(phoneLocator, phone);
    }
    public void fillTicketDetail(String subject, String detail){
        setText(subjectTextAreaLocator, subject);
        setText(detailTextAreaLocator, detail);
    }
    public void createTicket(){
        click(createTicketButtonLocator);
    }



}

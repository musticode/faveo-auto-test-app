package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

    public By departmentDropdown = By.cssSelector("#form > div > div.card-body > div:nth-child(2) > div.card-body > div > div:nth-child(1) > div:nth-child(3) > div > select");
    Select departmentSelect;


    public NewTicketPage(WebDriver driver) {
        super(driver);
    }
    public void getTicketCreate(){
        driver.get(APP_URL.concat("/newticket"));
    }
    public void selectDepartment(String departmentName){
        if (departmentName.equalsIgnoreCase("support")){
            departmentSelect = new Select(driver.findElement(departmentDropdown));
            departmentSelect.selectByIndex(1);
        }else if(departmentName.equalsIgnoreCase("sales")){
            departmentSelect = new Select(driver.findElement(departmentDropdown));
            departmentSelect.selectByIndex(2);
        }else if(departmentName.equalsIgnoreCase("maintenance")){
            departmentSelect = new Select(driver.findElement(departmentDropdown));
            departmentSelect.selectByIndex(3);
        }
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

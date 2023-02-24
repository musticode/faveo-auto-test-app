package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testapp.Ui.Pages.BasePage;

public class NewTicketPage extends BasePage {

    private By emailLocator = By.xpath("//input[contains(@id,'search')]");
    private By firstNameLocator = By.xpath("//input[contains(@name,'first_name')]");

    private By lastNameLocator = By.xpath("//input[contains(@name,'last_name')]");

    private By countryCodeLocator = By.xpath("//input[@name='code']");

    private By mobileLocator = By.xpath("//input[contains(@name,'mobile')]");

    private By phoneLocator = By.xpath("//input[contains(@type,'tel')]");

    private By helpTopicTextFieldLocator = By.xpath("//input[contains(@aria-labelledby,'vs1__combobox')]"); ////input[contains(@aria-labelledby,'vs1__combobox')]

    private By statusTextFieldLocator = By.xpath("//input[@aria-controls='vs2__listbox']");

    private By departmentTextFieldLocator = By.xpath("//input[contains(@aria-controls,'vs3__listbox')]");

    private By slaPlanTextFieldLocator = By.xpath("//input[contains(@aria-controls,'vs4__listbox')]");

    // ticket details locators
    private By subjectTextFieldLocator = By.xpath("//input[contains(@name,'subject')]");
    private By detailTextFieldLocator = By.xpath("//div[contains(@role,'textbox')]");
    private By priorityTextFieldLocator = By.xpath("//input[contains(@aria-controls,'vs9__listbox')]");


    //create ticket button locator
    private By createTicketButtonLocator = By.xpath("//input[contains(@value,'Create ticket')]");



    public NewTicketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void createTicketButton(){
        click(createTicketButtonLocator);
    }

    public void setPriorityTextField(String priority){
        setText(priorityTextFieldLocator, priority);
        setEnter(priorityTextFieldLocator);
    }

    public void setSubjectTextField(String subject){
        setText(subjectTextFieldLocator, subject);
    }

    public void setDetail(String detail){
        setText(detailTextFieldLocator, detail);
    }

    public void setTextSlaPlanTextField(String slaPlanText){
        setText(slaPlanTextFieldLocator, slaPlanText);
        setEnter(slaPlanTextFieldLocator);
    }
    public void setTextDepartmentTextField(String departmentText) {
        setText(departmentTextFieldLocator, departmentText);
        setEnter(departmentTextFieldLocator);
    }

    public void setTextStatusTextField(String statusText){
        setText(statusTextFieldLocator, statusText);
        setEnter(statusTextFieldLocator);
    }



    public void setTextHelpTopicTextField(String helpTopicText){
        setText(helpTopicTextFieldLocator, helpTopicText);
        setEnter(helpTopicTextFieldLocator);
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


}

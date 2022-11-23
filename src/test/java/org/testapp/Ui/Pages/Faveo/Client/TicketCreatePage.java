package org.testapp.Ui.Pages.Faveo.Client;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;

public class TicketCreatePage extends BasePage {

    //page elements
    private By chooseHelpTopicDropdownLocator = By.xpath("//*[@id=\"helptopic\"]");
    private By statusDropdownLocator = By.xpath("//*[@id=\"status_id\"]");
    private By typeDropdownLocator = By.xpath("//*[@id=\"type_id\"]");
    private By priorityDropdownLocator = By.xpath("//*[@id=\"section-categories\"]/div/div[4]/div/div[2]/select");
    private By subjectTextAreaLocator = By.id("Subject");
    private By messageTextAreaLocator = By.xpath("//*[@id=\"section-categories\"]/div/div[6]/div/div[3]/div[2]");
    private By submitButtonLocator = By.xpath("//*[@id=\"section-categories\"]/div/div[10]/input");

    public TicketCreatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Get ticket create page")
    public TicketCreatePage getTicketCreatePage(){
        driver.get(APP_URL.concat("/create-ticket"));
        return this;
    }

    @Step("Submit ticket with {subject} and {message}")
    public void submitTicket( String subject, String message){
        select(chooseHelpTopicDropdownLocator, 1);
        select(statusDropdownLocator, 1);
        select(typeDropdownLocator, 1);
        select(priorityDropdownLocator, 1);
        setText(subjectTextAreaLocator, subject);
        setText(messageTextAreaLocator, message);
        scrollDown();
        click(submitButtonLocator);
    }




}

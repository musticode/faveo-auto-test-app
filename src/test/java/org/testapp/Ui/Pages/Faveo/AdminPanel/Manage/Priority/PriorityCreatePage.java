package org.testapp.Ui.Pages.Faveo.AdminPanel.Manage.Priority;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;

public class PriorityCreatePage extends BasePage {

    //create page objects
    private By priorityNameInputLocator  = By.cssSelector("input[name='priority']");
    private By priorityDescriptionInputLocator = By.cssSelector("input[name='priority_desc']");
    private By priorityColorInputLocator = By.cssSelector("input[name='priority_color']");
    private By activeStatusRadioButtonLocator = By.cssSelector("");
    private By visibilityStatusRadioButtonLocator = By.cssSelector("");
    private By adminNoteInputLocator = By.xpath("/html/body/div[1]/div[1]/section[2]/form/div/div[2]/div[3]/div/div[3]/div[2]");
    private By submitButtonLocator = By.cssSelector("input[value='Submit']");


    //update page objects
    private By updateSubmitButtonLocator = By.cssSelector("input[value='Update']");



    public PriorityCreatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Step("Create ticket priority")
    public void createTicketPriority(String priorityName, String priorityDescription, String colorCode, String adminNote){
        setText(priorityNameInputLocator, priorityName);
        setText(priorityDescriptionInputLocator, priorityDescription);
        setText(priorityColorInputLocator, colorCode);

//        click(activeStatusRadioButtonLocator);
//        click(visibilityStatusRadioButtonLocator);

        setText(adminNoteInputLocator, adminNote);
//        click(submitButtonLocator);

    }

    @Step("Edit ticket priority")
    public void editTicketPriority(String priorityName, String priorityDescription, String colorCode, String adminNote){
        setText(priorityNameInputLocator, priorityName);
        setText(priorityDescriptionInputLocator, priorityDescription);
        setText(priorityColorInputLocator, colorCode);
        setText(adminNoteInputLocator, adminNote);
        scrollDown();
        click(updateSubmitButtonLocator);

    }




}

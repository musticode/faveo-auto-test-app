package org.testapp.Ui.Pages.Faveo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;
import org.testng.Assert;

public class TicketDetailsPage extends BasePage {

    public TicketDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    private By editTicketButton = By.id("Edit_Ticket");

    @FindBy(xpath = "//button[text()=' Assign']")
    public WebElement assignButton;


    //edit modal components
    private By titleTextLocator = By.name("subject");
    private By updateButtonLocator = By.xpath("//input[@value='Update']");
    private By closeButtonLocator  = By.xpath("//div[@class='modal fade show']//button[@type='button'][normalize-space()='Close']");


    //actions
    private By replyContentTextAreaLocator = By.xpath("//div[@class='tab-pane active']//form//div//div[contains(@class,'form-group')]//div[@class='row']//div[@class='col-md-10']//div//div[@role='textbox']");
    private By updateActionButtonLocator = By.id("replybtn");
    private By internalNotesNavLinkLocator = By.xpath("//a[normalize-space()='Internal notes']");
    private By internalNoteTextAreaLocator = By.xpath("//form[@method='POST']//div[@role='textbox']");
    private By updateInternalNoteButtonLocator = By.xpath("//*[@id=\"t4\"]/div[2]/div/div[2]/button");
    private By cannedResponseDropdown = By.xpath("//*[@id=\"select\"]");


    //worktime actions

    private By workTimeAddingCollapseLocator = By.xpath("/html/body/div[1]/div[1]/section/div[1]/div[6]/div[2]/div[9]/div/button");
    private By addWorkTimeTrackerButtonLocator= By.cssSelector("button[data-target='#timeTracker']");
    private By workTimeHourInputTextLocator = By.id("hour");
    private By workTimeMinuteInputTextLocator = By.id("min");
    private By timeTrackDescriptionInputLocator = By.id("description");
    private By saveTimeTrackSubmitButtonLocator = By.xpath("//*[@id=\"timeTracker\"]/div/div/div[4]/button[2]");
    private By editWorkTimeButtonLocator = By.xpath("//*[@id=\"hide2\"]/div/div/button[1]");
    private By deleteWorkTimeButtonLocator = By.xpath("//*[@id=\"hide2\"]/div/div/button[2]");



    @Step("Update ticket details with {ticketDetailTitle}")
    public void updateTicketDetail(String ticketDetailTitle){
        click(editTicketButton);
        setText(titleTextLocator, ticketDetailTitle);
        click(updateButtonLocator);
    }

    @Step("Close ticket details with {ticketDetailTitle}")
    public void closeTicketDetail(String ticketDetailTitle){
        click(editTicketButton);
        setText(titleTextLocator, ticketDetailTitle);
        click(closeButtonLocator);
    }

    @Step("Add reply to ticket {replyContent}")
    public void addReplyToTicket(String replyContent){
        setText(replyContentTextAreaLocator, replyContent);
//        select(cannedResponseDropdown, 1);
        click(updateActionButtonLocator);
    }

    @Step("Add internal note to ticket {internalNote}")
    public void addInternalNoteToTicket(String internalNote){
        click(internalNotesNavLinkLocator);
        setText(internalNoteTextAreaLocator, internalNote);
        scrollDown();
        click(updateInternalNoteButtonLocator);
    }

    @Step("Add work time to ticket with {hourWorkTime} {minuteWorkTime} {workTimeDescription}")
    public TicketDetailsPage addWorkTime(String hourWorkTime, String minuteWorkTime, String workTimeDescription) throws InterruptedException {
        scrollDownDoc();
        scrollDownDoc();
        click(workTimeAddingCollapseLocator);
//        scrollDownDoc();
//        Thread.sleep(3000);
        click(addWorkTimeTrackerButtonLocator);
        setText(workTimeHourInputTextLocator, hourWorkTime);
        setText(workTimeMinuteInputTextLocator, minuteWorkTime);
        setText(timeTrackDescriptionInputLocator, workTimeDescription);
        click(saveTimeTrackSubmitButtonLocator);
//        Thread.sleep(3000);

        return this;

    }

    @Step("Update work time")
    public TicketDetailsPage editWorkTime(String hourWorkTime, String minuteWorkTime, String workTimeDescription){

        //end of the page
        //scrollDownDoc();
        //click(workTimeAddingCollapseLocator);

        //scrollDown();
        click(editWorkTimeButtonLocator);

        //edit time track modal
        setText(workTimeHourInputTextLocator, hourWorkTime);
        setText(workTimeMinuteInputTextLocator, minuteWorkTime);
        setText(timeTrackDescriptionInputLocator, workTimeDescription);
        click(saveTimeTrackSubmitButtonLocator);

        return this;
    }

    @Step("Delete work time")
    public TicketDetailsPage deleteWorkTime(){

        //end of the page
        scrollDownDoc();
        click(workTimeAddingCollapseLocator);
        scrollDown();

        //click delete
        click(deleteWorkTimeButtonLocator);
        alertAccept();

        return this;
    }




    //assertion
    @Step("Check Title Details Page opened")
    public void checkTicketDetailsPageOpened(){
        Assert.assertEquals(isDisplayed(editTicketButton), true, "Details page is not opened!");
    }




}

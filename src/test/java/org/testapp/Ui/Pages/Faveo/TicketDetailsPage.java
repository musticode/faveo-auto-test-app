package org.testapp.Ui.Pages.Faveo;

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

    public void updateTicketDetail(String ticketDetailTitle){
        click(editTicketButton);
        setText(titleTextLocator, ticketDetailTitle);
        click(updateButtonLocator);
    }

    public void closeTicketDetail(String ticketDetailTitle){
        click(editTicketButton);
        setText(titleTextLocator, ticketDetailTitle);
        click(closeButtonLocator);
    }

    public void addReplyToTicket(String replyContent){
        setText(replyContentTextAreaLocator, replyContent);
//        select(cannedResponseDropdown, 1);
        click(updateActionButtonLocator);
    }

    public void addInternalNoteToTicket(String internalNote){
        click(internalNotesNavLinkLocator);
        setText(internalNoteTextAreaLocator, internalNote);
        scrollDown();
        click(updateInternalNoteButtonLocator);
    }





    //assertion
    public void checkTicketDetailsPageOpened(){
        Assert.assertEquals(isDisplayed(editTicketButton), true, "Details page is not opened!");
    }




}

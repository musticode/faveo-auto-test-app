package org.testapp.Ui.Pages.Faveo.AdminPanel.Tickets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class StatusPage extends BasePage {


    private By createTicketStatusButton = By.xpath("");
    private By statusNameTextLocator = By.xpath("");
    private By displayOrderLocator = By.xpath("");
    private By colorTextLocator = By.xpath("");
    private By purposeOfStatusDropdownLocator = By.xpath("");
    private By statusToDisplayLocator = By.xpath("");
    private By submitButton = By.xpath("");




    public StatusPage(WebDriver driver) {
        super(driver);
    }

    public void createStatus(String statusName, String displayOrder, String color){
        click(createTicketStatusButton);
        setText(statusNameTextLocator, statusName);
        setText(displayOrderLocator, displayOrder);
        setText(colorTextLocator, color);
        click(purposeOfStatusDropdownLocator);
        click(statusToDisplayLocator);
        click(submitButton);
    }
}

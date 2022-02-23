package org.testapp.Ui.Pages.Faveo.AdminPanel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// about:blank
public class TicketsAdminPage {
    // No page elements added

    public TicketsAdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
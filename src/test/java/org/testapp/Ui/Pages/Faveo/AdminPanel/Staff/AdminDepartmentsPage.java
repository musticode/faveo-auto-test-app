package org.testapp.Ui.Pages.Faveo.AdminPanel.Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// about:blank
public class AdminDepartmentsPage {
    // No page elements added

    @FindBy(css = "aa")
    public WebElement el;



    public AdminDepartmentsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



}
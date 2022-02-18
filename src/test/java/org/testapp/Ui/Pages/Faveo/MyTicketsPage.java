package org.testapp.Ui.Pages.Faveo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;
import org.testng.Assert;

public class MyTicketsPage extends BasePage {
    private By myTicketsTableNameLocator = By.xpath("//h3[normalize-space()='My tickets']");


    public MyTicketsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check My Ticket page is opened")
    public void checkMyticketsPageOpened(){
        Assert.assertEquals(getText(myTicketsTableNameLocator),"My tickets","My tickets page is not opened");
    }
}

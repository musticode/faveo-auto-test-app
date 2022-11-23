package org.testapp.Ui.Pages.Faveo.AdminPanel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;
import org.testapp.Ui.Pages.Faveo.AdminPanel.Tickets.StatusPage;
import org.testng.Assert;

public class AdminPanelDashboardPage extends BasePage {
    @FindBy (xpath = "a")
    private WebElement el;
    
    
    private By adminPanelTextLocator = By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/h1[2]");
    private By ticketsNavbarLocator = By.xpath("");
    private By statusNavbarLocator = By.xpath("");

    private StatusPage statusPage;
    public AdminPanelDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }




    public StatusPage getStatusPage(){
        click(ticketsNavbarLocator);
        click(statusNavbarLocator);

        if(statusPage == null){
            statusPage = new StatusPage(driver);
        }
        return statusPage;
    }







    @Step("Get admin panel with redirection")
    public AdminPanelDashboardPage getAdminPanelDashboardPage(){
        driver.get(APP_URL.concat("/admin"));
        return this;
    }

    @Step("is admin panel opened")
    public boolean isAdminPanelDashboardPageOpened(){
        return getText(adminPanelTextLocator).equalsIgnoreCase("Admin Panel");
    }

    public void checkAdminPanelOpened(){
        Assert.assertEquals(getText(adminPanelTextLocator), "Admin Panel", "Admin panel is not opened");
    }

}

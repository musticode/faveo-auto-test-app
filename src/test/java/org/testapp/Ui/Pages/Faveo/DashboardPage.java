package org.testapp.Ui.Pages.Faveo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;
import org.testapp.Ui.Pages.Faveo.AdminPanel.AdminPanelDashboardPanel;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    private final String FAVEO_DASHBOARD = "https://sprint9stag1msp.osticket.dmdemo.comodo.com/dashboard";

    private By navbarTicketsLocator = By.id("ticket_tab");
    private By navBarCreateTicketLocator = By.cssSelector("#tab_ticket > nav > ul > li:nth-child(5) > a");


    private By dropdownUserMenuLocator = By.cssSelector(".nav-item.dropdown.user-menu");

    private By userNameProfileNavbarLocator = By.xpath("/html/body/div[1]/aside/div/div[4]/div/div/div");

    private By adminPanelNavItemLocator = By.xpath("/html/body/div[1]/nav/ul[3]/li[1]/a");

    private By logoutDropDownLocator = By.xpath("/html/body/div[1]/nav/ul[3]/li[5]/a");
    private By signOutButtonLocator = By.xpath("/html/body/div[1]/nav/ul[3]/li[5]/ul/li[2]/a[2]");

    private By mailTexy = By.xpath("/html/body/div[1]/aside/div/div[4]/div/div/div");


    private By reportFrameInboxButtonLocator = By.xpath("/html/body/div[1]/div[1]/section/div/div[2]/div[1]/a/div");
    private By reportFrameUnassignedButtonLocator = By.xpath("/html/body/div[1]/div[1]/section/div/div[2]/div[2]/a/div");
    private By reportFrameOverdueButtonLocator = By.xpath("/html/body/div[1]/div[1]/section/div/div[2]/div[3]/a/div");
    private By reportFrameMyticketsButtonLocator = By.xpath("/html/body/div[1]/div[1]/section/div/div[2]/div[4]/a/div");
    private By reportFrameDueTodayButtonLocator = By.xpath("/html/body/div[1]/div[1]/section/div/div[2]/div[5]/a/div");

    private NewTicketPage newTicketPage;
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step("Sign out")
    public void signOut(){
        click(logoutDropDownLocator);
        click(signOutButtonLocator);
    }


    public void checkDashboardOpened(){
        Assert.assertTrue(isDisplayed(userNameProfileNavbarLocator),"Dashboard is not opened");
    }

    public void checkLogin(){
        Assert.assertTrue(isDisplayed(userNameProfileNavbarLocator),"Dashboard is not opened, not logged in");
    }

    public void checkWithString(String mail){
        Assert.assertEquals(getText(mailTexy), mail, "Email not matching");
    }


    @Step("Is dashboard page opened")
    public boolean isDashboardPageOpened(){

        return isDisplayed(userNameProfileNavbarLocator);
    }

    @Step("Navigate to dashboard page")
    public void getFaveoDashboard(){
        driver.get(APP_URL.concat("/dashboard"));
    }
    @Step("Navigate to create new ticket")
    public NewTicketPage getNewCreateTicket(){
        click(navbarTicketsLocator);
        click(navBarCreateTicketLocator);
        return newTicketPage = new NewTicketPage(driver);
    }
    private AdminPanelDashboardPanel adminPanelDashboardPanel;

    @Step("Navigate to Admin Panel DashboardPage")
    public AdminPanelDashboardPanel navigateToAdminPanelDashboardPage(){
        click(adminPanelNavItemLocator);
        if(adminPanelDashboardPanel == null){
            adminPanelDashboardPanel = new AdminPanelDashboardPanel(driver);
        }
        return adminPanelDashboardPanel;
    }


}

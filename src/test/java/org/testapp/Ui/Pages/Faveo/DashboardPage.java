package org.testapp.Ui.Pages.Faveo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;
import org.testapp.Ui.Pages.Faveo.AdminPanel.AdminPanelDashboardPanel;

public class DashboardPage extends BasePage {
    private final String FAVEO_DASHBOARD = "https://sprint9stag1msp.osticket.dmdemo.comodo.com/dashboard";

    private By navbarTicketsLocator = By.id("ticket_tab");
    private By navBarCreateTicketLocator = By.cssSelector("#tab_ticket > nav > ul > li:nth-child(5) > a");


    private By dropdownUserMenuLocator = By.cssSelector(".nav-item.dropdown.user-menu");

    private By userNameProfileNavbarLocator = By.xpath("/html/body/div[1]/aside/div/div[4]/div/div/div");

    private By adminPanelNavItemLocator = By.xpath("/html/body/div[1]/nav/ul[3]/li[1]/a");

    private NewTicketPage newTicketPage;
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    @Step("Is dashboard page opened")
    public boolean isDashboardPageOpened(){
        return isDisplayed(userNameProfileNavbarLocator);
    }

    @Step("Navigate to dashboard page")
    public void getFaveoDashboard(){
        driver.get(FAVEO_DASHBOARD);
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

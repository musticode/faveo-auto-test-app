package org.testapp.Ui.Test;

import org.testapp.Ui.Listener.TestListener;
import org.testapp.Ui.Pages.Faveo.AdminPanel.AdminPanelDashboardPanel;
import org.testapp.Ui.Pages.Faveo.LandinPage;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Pages.Faveo.NewTicketPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class ServiceDeskV2Test extends BaseTest{
    String testEmail = "mustafa.karatas.msp@yopmail.com";
    String testPwd = "Comodo456*";

/*
    String c1Test8FebDomain = "https://c1test8feb.osticket.dmdemo.comodo.com/";
    String agentMail = "mustafatest8feb@yopmail.com";
    String agentPassword = "Comodo456*";
*/

    LoginPage loginPage;

    @Test
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(testEmail, testPwd);

        boolean dashboardOpened = loginPage.getDashboardPage().isDashboardPageOpened();
        Assert.assertEquals(dashboardOpened,
                true,
                "Dashboard opened");


    }

    NewTicketPage newTicketPage;
    @Test(dependsOnMethods = "staffLoginWithValidCredentials")
    public void createTestTicket(){
        loginPage = new LoginPage(driver);
        newTicketPage = new NewTicketPage(driver);

        newTicketPage.getTicketCreate();
        newTicketPage.fillUserDetails(
                "mustafa@yopmail.com",
                "mustafa",
                "karatas",
                "90",
                "5434593612",
                "123");

        newTicketPage.fillTicketDetail("Test Subject for Automation", "Test detail");
        newTicketPage.createTicket();
    }

    @Test(dependsOnMethods = "staffLoginWithValidCredentials")
    public void navigateToAdminPanelAfterLogin(){
        loginPage = new LoginPage(driver);
        boolean adminPanelOpenedStatus =
                loginPage
                .getDashboardPage()
                .navigateToAdminPanelDashboardPage()
                .isAdminPanelDashboardPageOpened();

        Assert.assertEquals(
                adminPanelOpenedStatus,
                true,
                "Admin panel is not opened");

    }

    AdminPanelDashboardPanel adminPanelDashboardPanel;
    @Test
    public void redirectToAdminPanelAfterLogin(){
        adminPanelDashboardPanel = new AdminPanelDashboardPanel(driver);
        adminPanelDashboardPanel.getAdminPanelDashboardPage();
        boolean adminPanelOpenedStatus = adminPanelDashboardPanel.isAdminPanelDashboardPageOpened();

        Assert.assertEquals(adminPanelOpenedStatus,
                false,
                "Admin panel is opened with redirection");
    }



    LandinPage landinPage;
    @Test
    public void landingPageNavigations(){
        landinPage = new LandinPage(driver);
        landinPage.navigateTo("login");
    }





}

package org.testapp.Ui.Test.ParallelTests;

import org.testapp.Ui.Pages.Faveo.AdminPanel.AdminPanelDashboardPage;
import org.testapp.Ui.Pages.Faveo.LandingPage;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Pages.Faveo.NewTicketPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OSTicketParallelTest extends BaseTestFactory {
    String testEmail = "mustafa.karatas.msp@yopmail.com";
    String testPwd = "Comodo456*";

    LoginPage loginPage;
    @Test(priority = 0)
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(testEmail, testPwd);

        boolean dashboardOpened = loginPage.getDashboardPage().isDashboardPageOpened();
        Assert.assertEquals(dashboardOpened,
                true,
                "Dashboard opened");
    }
    @Test(priority = 1)
    public void staffLoginWithInvalidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(testEmail, "asdaasdasd");

        boolean loginNotSuccessfully = loginPage.isAlertSeenAfterInvalidLogin();

        Assert.assertEquals(loginNotSuccessfully, true, "Valid login");
    }



    NewTicketPage newTicketPage;
    @Test(priority = 2)
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

//        newTicketPage.fillTicketDetail("Test Subject for Automation", "Test detail");
//        newTicketPage.createTicket();
    }

    @Test(priority = 3)
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

    AdminPanelDashboardPage adminPanelDashboardPage;
    @Test (priority = 4)
    public void redirectToAdminPanelAfterLogin(){
        adminPanelDashboardPage = new AdminPanelDashboardPage(driver);
        adminPanelDashboardPage.getAdminPanelDashboardPage();

        boolean adminPanelOpenedStatus = adminPanelDashboardPage.isAdminPanelDashboardPageOpened();

        Assert.assertEquals(adminPanelOpenedStatus,
                false,
                "Admin panel is opened with redirection");
    }



    LandingPage landinPage;
    @Test(priority = 5)
    public void landingPageNavigations(){
        landinPage = new LandingPage(driver);
        landinPage.navigateTo("login");
    }


}

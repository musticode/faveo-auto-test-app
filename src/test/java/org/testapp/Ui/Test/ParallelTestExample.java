package org.testapp.Ui.Test;

import org.testapp.Ui.Pages.DemoQAPages.DemoPageTextBox;
import org.testapp.Ui.Pages.Faveo.AdminPanel.AdminPanelDashboardPanel;
import org.testapp.Ui.Pages.Faveo.LandingPage;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Pages.Faveo.NewTicketPage;
import org.testapp.Ui.Test.TestBase.BaseRemoteTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelTestExample extends BaseRemoteTest {
    String FULL_NAME = "Mustafa";
    String EMAIL = "test@yopmail.com";
    String CURRENT_ADDRESS = "current address";
    String PARMANENT_ADDRESS = "parmanent address";

    DemoPageTextBox demoPageTextBox;
    @Test
    public void parallel1() {
            demoPageTextBox = new DemoPageTextBox(getDriver());
            demoPageTextBox.fillTextBox(FULL_NAME, EMAIL, CURRENT_ADDRESS, PARMANENT_ADDRESS);
            demoPageTextBox.submit();
            System.out.println(demoPageTextBox.getOutput());

            Assert.assertEquals(demoPageTextBox.getOutput(),
                    "Name:"+FULL_NAME+"\n" +
                            "Email:"+EMAIL+"\n" +
                            "Current Address :"+CURRENT_ADDRESS+"\n" +
                            "Permananet Address :"+PARMANENT_ADDRESS,
                    "Not matching with output");
        }

    String testEmail = "mustafa.karatas.msp@yopmail.com";
    String testPwd = "Comodo456*";

/*
    String c1Test8FebDomain = "https://c1test8feb.osticket.dmdemo.comodo.com/";
    String agentMail = "mustafatest8feb@yopmail.com";
    String agentPassword = "Comodo456*";
*/

    LoginPage loginPage;

    @Test(priority = 0)
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(getDriver());
        loginPage.staffLogin(testEmail, testPwd);

        boolean dashboardOpened = loginPage.getDashboardPage().isDashboardPageOpened();
        Assert.assertEquals(dashboardOpened,
                true,
                "Dashboard opened");
    }
    @Test(priority = 1)
    public void staffLoginWithInvalidCredentials(){
        loginPage = new LoginPage(getDriver());
        loginPage.staffLogin(testEmail, "asdaasdasd");

        boolean loginNotSuccessfully = loginPage.isAlertSeenAfterInvalidLogin();

        Assert.assertEquals(loginNotSuccessfully, true, "Valid login");
    }



    NewTicketPage newTicketPage;
    @Test(priority = 2)
    public void createTestTicket(){
        loginPage = new LoginPage(getDriver());
        newTicketPage = new NewTicketPage(getDriver());

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

    @Test(priority = 3)
    public void navigateToAdminPanelAfterLogin(){
        loginPage = new LoginPage(getDriver());
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
    @Test (priority = 4)
    public void redirectToAdminPanelAfterLogin(){
        adminPanelDashboardPanel = new AdminPanelDashboardPanel(getDriver());
        adminPanelDashboardPanel.getAdminPanelDashboardPage();

        boolean adminPanelOpenedStatus = adminPanelDashboardPanel.isAdminPanelDashboardPageOpened();

        Assert.assertEquals(adminPanelOpenedStatus,
                false,
                "Admin panel is opened with redirection");
    }



    LandingPage landinPage;
    @Test(priority = 5)
    public void landingPageNavigations(){
        landinPage = new LandingPage(getDriver());
        landinPage.navigateTo("login");
    }





}

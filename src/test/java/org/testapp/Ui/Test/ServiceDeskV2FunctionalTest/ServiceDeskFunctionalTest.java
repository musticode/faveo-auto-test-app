package org.testapp.Ui.Test.ServiceDeskV2FunctionalTest;

import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Pages.Faveo.DashboardPage;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Pages.Faveo.NewTicketPage;
import org.testapp.Ui.Test.TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ServiceDeskFunctionalTest extends BaseTest {

    final String TEST_EMAIL = PropertyManager.getInstance().getTestEmail();
    final String TEST_PWD = PropertyManager.getInstance().getTestPassword();

    LoginPage loginPage;

    @Test()
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(TEST_EMAIL, TEST_PWD);

        boolean dashboardOpened = loginPage.getDashboardPage().isDashboardPageOpened();
        Assert.assertEquals(dashboardOpened,
                true,
                "Dashboard opened");
    }

    NewTicketPage newTicketPage;
    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void createTestTicketWithDepartment(){
        newTicketPage = new NewTicketPage(driver);

        newTicketPage.getTicketCreate();
        newTicketPage.fillUserDetails(
                "mustafa@yopmail.com",
                "mustafa",
                "karatas",
                "90",
                "5434593612",
                "123");
        newTicketPage.selectDepartment("support");
        newTicketPage.fillTicketDetail("Test Subject for Automation", "Test detail");
//        newTicketPage.createTicket();
    }





    DashboardPage dashboardPage;
    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void signOut(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.getFaveoDashboard();
        dashboardPage.signOut();

    }



}

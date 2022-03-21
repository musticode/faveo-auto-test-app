package org.testapp.Ui.Test;

import io.qameta.allure.Description;
import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Pages.Faveo.AdminPanel.AdminPanelDashboardPage;
import org.testapp.Ui.Pages.Faveo.AdminPanel.Manage.Priority.PriorityPage;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Test.TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPanelTestScenarios extends BaseTest {
    //constants
    final String TEST_EMAIL = PropertyManager.getInstance().getTestEmail();
    final String TEST_PWD = PropertyManager.getInstance().getTestPassword();

    //page variables
    LoginPage loginPage;
    AdminPanelDashboardPage adminPanelDashboardPage;
    PriorityPage priorityPage;




    @Test(priority = 0)
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(TEST_EMAIL, TEST_PWD);

        boolean dashboardOpened = loginPage.getDashboardPage().isDashboardPageOpened();
        Assert.assertEquals(dashboardOpened,
                true,
                "Dashboard opened");
    }

    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    @Description("Open admin panel test")
    public void getAdminPanelTest(){
        adminPanelDashboardPage = new AdminPanelDashboardPage(driver);
        adminPanelDashboardPage.getAdminPanelDashboardPage();
        adminPanelDashboardPage.checkAdminPanelOpened();
    }

    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void priorityAddTest(){
        /*
        * login
        * get priority page
        * click create
        * priority name inp
        * desc inp
        * color inp
        * stat act
        * visibility public
        * adm notes inp
        * click submit
        *  */

        priorityPage = new PriorityPage(driver);
        priorityPage
                .getPriorityPage()
                .getPriorityCreatePage()
                .createTicketPriority(
                        "TEST P",
                        "TEST Description",
                        "#f90000",
                        "TEST Admin Note"
                );

    }

    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void priorityEditTest(){
        /*
         * login
         * get priority page
         * click create
         * priority name inp
         * desc inp
         * color inp
         * stat act
         * visibility public
         * adm notes inp
         * click submit
         *  */

        priorityPage = new PriorityPage(driver);
        priorityPage
                .getPriorityPage()
                .editPriority()
                .editTicketPriority(
                        "Test Low",
                        "Low_update",
                        "#00a65a",
                        "TEST Admin Note edit"
                );

    }





}

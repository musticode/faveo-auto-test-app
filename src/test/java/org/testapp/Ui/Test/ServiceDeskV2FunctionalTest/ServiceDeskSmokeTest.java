package org.testapp.Ui.Test.ServiceDeskV2FunctionalTest;

import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Pages.Faveo.DashboardPage;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Pages.Faveo.ProfilePage;
import org.testapp.Ui.Test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ServiceDeskSmokeTest extends BaseTest {

    final String TEST_EMAIL = PropertyManager.getInstance().getTestEmail();
    final String TEST_PWD = PropertyManager.getInstance().getTestPassword();

    LoginPage loginPage;

    @Test()
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(TEST_EMAIL, TEST_PWD);
        loginPage.getDashboardPage().checkLogin();
        loginPage.getDashboardPage().checkWithString(TEST_EMAIL);
    }

    DashboardPage dashboardPage;
    @Test (dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getDashboardPage(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.getFaveoDashboard();
        dashboardPage.checkDashboardOpened();
    }

    ProfilePage profilePage;
    @Test (dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getProfilePage(){
        profilePage = new ProfilePage(driver);
        profilePage.getProfilePage();
        profilePage.checkProfilePageOpened();
    }


}

package org.testapp.Ui.Test.ServiceDeskV2FunctionalTest;

import io.qameta.allure.Description;
import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Listener.TestListener;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListener.class)
public class ServiceDeskV2AdminPanelTest extends BaseTestFactory {

    final String TEST_EMAIL = PropertyManager.getInstance().getTestEmail();
    final String TEST_PWD = PropertyManager.getInstance().getTestPassword();

    LoginPage loginPage;

    @Test(priority = 0)
    @Description("Login with valid credentials ")
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(TEST_EMAIL, TEST_PWD);
        loginPage.getDashboardPage().checkLogin();
        loginPage.getDashboardPage().checkWithString(TEST_EMAIL);
    }











}

package org.testapp.Ui.Test;

import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Pages.DemoQAPages.DemoPage;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWithBaseFactory extends BaseTestFactory {
    DemoPage demoPage;
    @Test
    void test1(){
        demoPage = new DemoPage(driver);
        demoPage.openPage();
    }

    final String TEST_EMAIL = PropertyManager.getInstance().getTestEmail();
    final String TEST_PWD = PropertyManager.getInstance().getTestPassword();

    LoginPage loginPage;

    @Test(priority = 0)
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(TEST_EMAIL, TEST_PWD);

        boolean dashboardOpened = loginPage.getDashboardPage().isDashboardPageOpened();
        Assert.assertEquals(dashboardOpened,
                true,
                "Dashboard opened");
    }


}

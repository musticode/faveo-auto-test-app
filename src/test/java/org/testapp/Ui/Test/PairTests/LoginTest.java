package org.testapp.Ui.Test.PairTests;

import org.jboss.aerogear.security.otp.Totp;
import org.testapp.Ui.Pages.Pair.LoginPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestFactory {

    LoginPage loginPage;



    @Test(priority = 0)
    public void pairLoginTest() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.getLoginPage();
        loginPage.login("overlaytest2@numsp.com", "comodo456*");

        Thread.sleep(10000);
        loginPage.ringCentralLogin("overlaytest2@numsp.com", "S3qr6y*^");

        Thread.sleep(10000);


    }


}

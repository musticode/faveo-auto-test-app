package org.testapp.Ui.Test.TnsTests;

import org.testapp.Ui.Listener.TestListener;
import org.testapp.Ui.Pages.TotalNocSupport.TnsDashboardPage;
import org.testapp.Ui.Pages.TotalNocSupport.TnsMainPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListener.class)
public class TnsTestLogin extends BaseTestFactory {


    TnsMainPage tnsMainPage;
    TnsDashboardPage tnsDashboardPage;

    private final String TNS_VALID_USERNAME = "testaccount21nov@yopmail.com";
    private final String TNS_VALID_PASSWORD = "Comodo456*";

    public void loginWithValidCredentials(){
        tnsMainPage = new TnsMainPage(driver);
        tnsMainPage.getMainPage();
        tnsMainPage.login(TNS_VALID_USERNAME, TNS_VALID_PASSWORD);
    }


    @Test
    public void loginWithItarianValidAccountTest(){
        tnsMainPage = new TnsMainPage(driver);
        tnsDashboardPage = new TnsDashboardPage(driver);


        tnsMainPage.getMainPage();
        tnsMainPage.login(TNS_VALID_USERNAME, TNS_VALID_PASSWORD);
        Assert.assertEquals(
                tnsDashboardPage.isTnsDashBoardPageOpened(),
                true,
                "Dashboard page is not opened"
        );

    }


    @Test
    public void logOutTest(){

        tnsMainPage = new TnsMainPage(driver);
        tnsDashboardPage = new TnsDashboardPage(driver);


        loginWithValidCredentials();

        tnsDashboardPage.logOut();

        Assert.assertEquals(
                tnsMainPage.isMainPageDisplayed(),
                true,
                "Log out can't be done"
        );




    }





}

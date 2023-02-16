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

    private final String TNS_USERNAME = "testaccount21nov@yopmail.com";
    private final String TNS_PASSWORD = "Comodo456*";

    @Test
    public void loginWithItarianValidAccountTest(){
        tnsMainPage = new TnsMainPage(driver);
        tnsDashboardPage = new TnsDashboardPage(driver);


        tnsMainPage.getMainPage();
        tnsMainPage.login(TNS_USERNAME, TNS_PASSWORD);
        Assert.assertEquals(
                tnsDashboardPage.isTnsDashBoardPageOpened(),
                true,
                "Dashboard page is not opened");


    }



}

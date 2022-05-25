package org.testapp.Ui.Test.ServiceDeskV2FunctionalTest;

import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Listener.TestListener;
import org.testapp.Ui.Pages.Faveo.Client.TicketCreatePage;
import org.testapp.Ui.Pages.Faveo.HomePage;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class ServiceDeskV2ClientTest extends BaseTestFactory {

    private String CLIENT_EMAIL = PropertyManager.getInstance().getTestClientEmail();
    private String CLIENT_PASSWORD = PropertyManager.getInstance().getTestClientPassword();



    //pages
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void clientLogin(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.clientlogin(CLIENT_EMAIL, CLIENT_PASSWORD);
        homePage.homePageOpened();
    }

    TicketCreatePage ticketCreatePage;
    @Test(dependsOnMethods = {"clientLogin"})
    public void submitTicketClient(){
        ticketCreatePage = new TicketCreatePage(driver);
        ticketCreatePage.getTicketCreatePage()
                .submitTicket("mustafa", "test");
    }

    @Test(dependsOnMethods = {"clientLogin"}, priority = 999)
    public void clientLogOut(){
        homePage = new HomePage(driver);
        homePage.signOutFromHomePage();
    }



}

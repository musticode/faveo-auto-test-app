package org.testapp.Ui.Test.ServiceDeskV2FunctionalTest;

import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Pages.Faveo.Client.TicketCreatePage;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testng.annotations.Test;

public class ServiceDeskV2ClientTest extends BaseTestFactory {

    private String CLIENT_EMAIL = PropertyManager.getInstance().getTestClientEmail();
    private String CLIENT_PASSWORD = PropertyManager.getInstance().getTestClientPassword();



    //pages
    LoginPage loginPage;

    @Test
    public void clientLogin(){
        loginPage = new LoginPage(driver);
        loginPage.clientlogin(CLIENT_EMAIL, CLIENT_PASSWORD);

    }

    TicketCreatePage ticketCreatePage;
    @Test(dependsOnMethods = {"clientLogin"})
    public void submitTicketClient(){
        ticketCreatePage = new TicketCreatePage(driver);
        ticketCreatePage.getTicketCreatePage()
                .submitTicket("mustafa", "test");
    }



}

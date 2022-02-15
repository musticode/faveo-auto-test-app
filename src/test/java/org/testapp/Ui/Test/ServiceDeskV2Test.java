package org.testapp.Ui.Test;

import org.testapp.Ui.Pages.Faveo.LandinPage;
import org.testapp.Ui.Pages.Faveo.LoginPage;
import org.testapp.Ui.Pages.Faveo.NewTicketPage;
import org.testng.annotations.Test;

public class ServiceDeskV2Test extends BaseTest{
    String testEmail = "mustafa.karatas.msp@yopmail.com";
    String testPwd = "Comodo456*";

    LoginPage loginPage;

    @Test
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(testEmail, testPwd);


    }

    NewTicketPage newTicketPage;
    @Test(dependsOnMethods = "staffLoginWithValidCredentials")
    public void createTestTicket(){
        loginPage = new LoginPage(driver);
        newTicketPage = new NewTicketPage(driver);

        newTicketPage.getTicketCreate();
        newTicketPage.fillUserDetails(
                "mustafa@yopmail.com",
                "mustafa",
                "karatas",
                "90",
                "5434593612",
                "123");

        newTicketPage.fillTicketDetail("Test Subject for Automation", "Test detail");
        newTicketPage.createTicket();
    }


    LandinPage landinPage;
    @Test
    public void landingPageNavigations(){
        landinPage = new LandinPage(driver);
        landinPage.navigateTo("login");
    }





}

package org.testapp.Ui.Test;

import io.qameta.allure.Description;
import org.testapp.Ui.Listener.TestListener;
import org.testapp.Ui.Pages.DemoQAPages.DemoPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(TestListener.class)
public class Scenario1 extends BaseRemoteTest{
    DemoPage demoPage;
    @Test
    @Description("Demo form page")
    public void scenario1(){
        demoPage = new DemoPage(getDriver());
        demoPage.openPage();
        demoPage.isPageOpened();
        demoPage.setName("Mustafa");
    }

/*    String email= "testemail@yopmail.com";


    DashboardPage dashboardPage;
    @Test
    public void createTestTicket(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.getFaveoDashboard();
        dashboardPage.createTicket().fillTicketCreateForm(email);
    }*/


}

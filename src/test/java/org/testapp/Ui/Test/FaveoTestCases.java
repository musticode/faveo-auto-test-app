package org.testapp.Ui.Test;

import org.testapp.Ui.Listener.TestListener;
import org.testapp.Ui.Pages.Faveo.DashboardPage;
import org.testapp.Ui.Pages.Faveo.LandingPage;
import org.testapp.Ui.Pages.Faveo.NewTicketPage;
import org.testapp.Ui.Pages.Faveo.TicketInboxPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;

//@Listeners(TestListener.class)
public class FaveoTestCases extends BaseTest{
    String testEmail = "mustafa.karatas.msp@yopmail.com";
    String testPwd = "Comodo456*";

    LandingPage landingPage;
    @Test
    public void loginWithValidCredentials(){
        landingPage = new LandingPage(driver);
        landingPage.login(testEmail, testPwd);

        Assert.assertEquals(landingPage.getHomepage().isHomePageOpened(),
                true,
                "Home page is not opened");
    }

    DashboardPage dashboardPage;
    @Test(dependsOnMethods = "loginWithValidCredentials")
    public void openDashboardPage(){
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);

        dashboardPage.getFaveoDashboard();
        Assert.assertEquals(dashboardPage.isDashboardPageOpened(),
                true,
                "Dashboard Page is not opened");


    }

    NewTicketPage newTicketPage;
    @Test(dependsOnMethods = "loginWithValidCredentials")
    public void createTestTicket(){
        landingPage = new LandingPage(driver);
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


    TicketInboxPage ticketInboxPage;
    @Test(dependsOnMethods = "loginWithValidCredentials")
    public void inboxTest(){
        ticketInboxPage = new TicketInboxPage(driver);
        System.out.println(ticketInboxPage.getTableElements());
        ticketInboxPage.checkTable("a");


    }

    @Test
    public void charArray(){
        String element = "Beyzatest 20January (4)\n" +
                "#AAAA-0000-0008 Normal Beyza İnce Mustafa Karataş 20/01/2022 14:03:15\n" +
                "Test subject (10)   \n" +
                "#AAAA-0000-0004 Low Beyza İnce Demo Admin 20/01/2022 14:00:59\n" +
                "Test subject 20 jan... (7)\n" +
                "#AAAA-0000-0007 Low Mustafa Karataş Abdullah Yavuz 20/01/2022 12:25:55\n" +
                "DASDASDASD (1)\n" +
                "#AAAA-0000-0003 High ASDASD Demo Admin 20/01/2022 08:31:19";


        String matchElement = "Beyzatest";

        char [] ch = element.toCharArray();
        for(char c : ch ){
            System.out.print(c);
        }

        char [] b =  matchElement.toCharArray();

        boolean retval = Arrays.equals(ch, b);
        System.out.println(retval); //false

        Arrays.asList(ch).contains(b);

        boolean contains = Arrays.asList(ch).contains(b);
        System.out.println("contains:" + contains);



    }




}

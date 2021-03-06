package org.testapp.Ui.Test.ServiceDeskV2FunctionalTest;

import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Listener.TestListener;
import org.testapp.Ui.Pages.Faveo.*;
import org.testapp.Ui.Pages.Faveo.AdminPanel.AdminPanelDashboardPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ServiceDeskSmokeTest extends BaseTestFactory {

    final String TEST_EMAIL = PropertyManager.getInstance().getTestEmail();
    final String TEST_PWD = PropertyManager.getInstance().getTestPassword();

    LoginPage loginPage;

    @Test(priority = 0)
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(TEST_EMAIL, TEST_PWD);
        //loginPage.getDashboardPage().checkLogin();
        //loginPage.getDashboardPage().checkWithString(TEST_EMAIL);
    }

    DashboardPage dashboardPage;
    @Test (priority = 1, dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getDashboardPage(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.getFaveoDashboard();
        //dashboardPage.checkDashboardOpened();
    }

    ProfilePage profilePage;
    @Test //(priority = 2, dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getProfilePage(){
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);

        //login as staff
        loginPage.staffLogin(TEST_EMAIL, TEST_PWD);
        //go to profile page
        profilePage.getProfilePage();
        profilePage.checkProfilePageOpened();
    }


    AdminPanelDashboardPage adminPanelDashboardPage;
    @Test (priority = 3, dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getAdminPanel(){
        adminPanelDashboardPage = new AdminPanelDashboardPage(driver);
        adminPanelDashboardPage.getAdminPanelDashboardPage();
        adminPanelDashboardPage.checkAdminPanelOpened();
    }


/*    NavBar navBar;
    @Test (dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getTicketInbox(){
        navBar = new NavBar(driver);
        navBar.getMyTicketsPage().checkMyticketsPageOpened();
    }
    */
    LandingPage landingPage;

    @Test (priority = 4)
    public void landingPageNavigationLogin(){
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);

        landingPage.getLandingPage();
        landingPage.navigateTo("login");
        loginPage.checkLoginPageOpened();

    }

    RegisterPage registerPage;
    @Test (priority = 5 )
    public void landingPageNavigationRegister(){
        landingPage = new LandingPage(driver);
        registerPage = new RegisterPage(driver);

        landingPage.getLandingPage();
        landingPage.navigateTo("register");
        registerPage.checkRegistrationPageOpened();
    }

    @Test (priority = 7 )
    public void checkMyTicketsPageWithoutLogin(){
        landingPage = new LandingPage(driver);
        landingPage.getLandingPage();
        landingPage.clickMytickets().checkLoginPageOpened();
    }

    @Test  (priority = 6 )
    public void checkKnowledgeBaseWithoutLogin(){
        landingPage = new LandingPage(driver);
        landingPage.getLandingPage();
        landingPage.getKnowledgeBase().checkLoginPageOpened();
    }

    TicketInboxPage ticketInboxPage;
    @Test(priority = 8, dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void ticketDetailsTest(){
        ticketInboxPage = new TicketInboxPage(driver);

        ticketInboxPage
                .getTicketInboxPage()
                .getTicketDetailsPage()
                .checkTicketDetailsPageOpened();
    }

    @Test(priority = 9, dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void editTicketDetailsTest() throws InterruptedException {
        Thread.sleep(Long.parseLong("10000"));
        ticketInboxPage = new TicketInboxPage(driver);
        ticketInboxPage
                .getTicketInboxPage()
                .getTicketDetailsPage()
                .closeTicketDetail("SMOKE TEST");
    }

    @Test(priority = 999, dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void signOut() throws InterruptedException {
        Thread.sleep(Long.parseLong("10000"));
        dashboardPage = new DashboardPage(driver);
        dashboardPage.getFaveoDashboard();
        dashboardPage.signOut();

    }





}

package org.testapp.Ui.Test.ServiceDeskV2FunctionalTest;

import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Listener.TestListener;
import org.testapp.Ui.Pages.Faveo.*;
import org.testapp.Ui.Pages.Faveo.AdminPanel.AdminPanelDashboardPanel;
import org.testapp.Ui.Test.TestBase.BaseTest;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ServiceDeskSmokeTest extends BaseTestFactory {

    final String TEST_EMAIL = PropertyManager.getInstance().getTestEmail();
    final String TEST_PWD = PropertyManager.getInstance().getTestPassword();

    LoginPage loginPage;

    @Test()
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(TEST_EMAIL, TEST_PWD);
        loginPage.getDashboardPage().checkLogin();
        loginPage.getDashboardPage().checkWithString(TEST_EMAIL);
    }

    DashboardPage dashboardPage;
    @Test (dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getDashboardPage(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.getFaveoDashboard();
        dashboardPage.checkDashboardOpened();
    }

    ProfilePage profilePage;
    @Test (dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getProfilePage(){
        profilePage = new ProfilePage(driver);
        profilePage.getProfilePage();
        profilePage.checkProfilePageOpened();
    }


    AdminPanelDashboardPanel adminPanelDashboardPanel;
    @Test (dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getAdminPanel(){
        adminPanelDashboardPanel = new AdminPanelDashboardPanel(driver);
        adminPanelDashboardPanel.getAdminPanelDashboardPage();
        adminPanelDashboardPanel.checkAdminPanelOpened();
    }


    NavBar navBar;
    @Test (dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getTicketInbox(){
        navBar = new NavBar(driver);
        navBar.getMyTicketsPage().checkMyticketsPageOpened();
    }

    LandingPage landingPage;

    @Test
    public void landingPageNavigationLogin(){
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);

        landingPage.getLandingPage();
        landingPage.navigateTo("login");
        loginPage.checkLoginPageOpened();

    }

    RegisterPage registerPage;
    @Test
    public void landingPageNavigationRegister(){
        landingPage = new LandingPage(driver);
        registerPage = new RegisterPage(driver);

        landingPage.getLandingPage();
        landingPage.navigateTo("register");
        registerPage.checkRegistrationPageOpened();
    }

    @Test
    public void checkMyTicketsPageWithoutLogin(){
        landingPage = new LandingPage(driver);
        landingPage.getLandingPage();
        landingPage.clickMytickets().checkLoginPageOpened();
    }

    @Test
    public void checkKnowledgeBaseWithoutLogin(){
        landingPage = new LandingPage(driver);
        landingPage.getLandingPage();
        landingPage.getKnowledgeBase().checkLoginPageOpened();
    }

    TicketInboxPage ticketInboxPage;
    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void ticketDetailsTest(){
        ticketInboxPage = new TicketInboxPage(driver);

        ticketInboxPage
                .getTicketInboxPage()
                .getTicketDetailsPage()
                .checkTicketDetailsPageOpened();
    }

    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void editTicketDetailsTest(){
        ticketInboxPage = new TicketInboxPage(driver);
        ticketInboxPage
                .getTicketInboxPage()
                .getTicketDetailsPage()
                .closeTicketDetail("SMOKE TEST");
    }





}

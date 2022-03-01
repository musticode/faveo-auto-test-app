package org.testapp.Ui.Test;

import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Listener.TestListener;
import org.testapp.Ui.Pages.Faveo.*;
import org.testapp.Ui.Pages.Faveo.AdminPanel.AdminPanelDashboardPanel;
import org.testapp.Ui.Test.TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class ServiceDeskV2Test extends BaseTest {

    final String TEST_EMAIL = PropertyManager.getInstance().getTestEmail();
    final String TEST_PWD = PropertyManager.getInstance().getTestPassword();

    LoginPage loginPage;

    @Test(priority = 0)
    public void staffLoginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(TEST_EMAIL, TEST_PWD);

        boolean dashboardOpened = loginPage.getDashboardPage().isDashboardPageOpened();
        Assert.assertEquals(dashboardOpened,
                true,
                "Dashboard opened");
    }


    @Test
    public void testGenericClick(){
        loginPage = new LoginPage(driver);
        loginPage.clickelTest();
    }


    @Test
    public void addStatusTicketTest(){
        adminPanelDashboardPanel = new AdminPanelDashboardPanel(driver);
        adminPanelDashboardPanel.getStatusPage().createStatus("Delete", "3","#f1627e" );

    }
/*

    @Test(priority = 1)
    public void staffLoginWithInvalidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.staffLogin(TEST_EMAIL, "asdaasdasd");

        boolean loginNotSuccessfully = loginPage.isAlertSeenAfterInvalidLogin();

        Assert.assertEquals(loginNotSuccessfully, true, "Valid login");
    }
*/



    NewTicketPage newTicketPage;
    @Test()
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

    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void createTestTicketThroughSupportDepartment(){
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

        newTicketPage.selectDepartment("support");
        newTicketPage.fillTicketDetail("Test Subject for Automation", "Test detail");
//        newTicketPage.createTicket();
    }



    @Test(priority = 3, dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void navigateToAdminPanelAfterLogin(){
        loginPage = new LoginPage(driver);
        boolean adminPanelOpenedStatus =
                loginPage
                .getDashboardPage()
                .navigateToAdminPanelDashboardPage()
                .isAdminPanelDashboardPageOpened();

        Assert.assertEquals(
                adminPanelOpenedStatus,
                true,
                "Admin panel is not opened");

    }

    AdminPanelDashboardPanel adminPanelDashboardPanel;
    @Test (priority = 4)
    public void redirectToAdminPanelAfterLogin(){
        adminPanelDashboardPanel = new AdminPanelDashboardPanel(driver);
        adminPanelDashboardPanel.getAdminPanelDashboardPage();

        boolean adminPanelOpenedStatus = adminPanelDashboardPanel.isAdminPanelDashboardPageOpened();

        Assert.assertEquals(adminPanelOpenedStatus,
                false,
                "Admin panel is opened with redirection");
    }



    LandingPage landinPage;
    @Test(priority = 5)
    public void landingPageNavigations(){
        landinPage = new LandingPage(driver);
        landinPage.navigateTo("login");
    }


    DashboardPage dashboardPage;
    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void signOut(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.getFaveoDashboard();
        dashboardPage.signOut();

    }

    ProfilePage profilePage;
    @Test (dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getProfilePage(){
        profilePage = new ProfilePage(driver);
        profilePage.getProfilePage();
        profilePage.checkProfilePageOpened();
    }



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
        landinPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);

        landinPage.getLandingPage();
        landinPage.navigateTo("login");
        loginPage.checkLoginPageOpened();

    }

    RegisterPage registerPage;
    @Test
    public void landingPageNavigationRegister(){
        landinPage = new LandingPage(driver);
        registerPage = new RegisterPage(driver);

        landinPage.getLandingPage();
        landinPage.navigateTo("register");
        registerPage.checkRegistrationPageOpened();
    }


    @Test
    public void checkMyTicketsPageWithoutLogin(){
        landinPage = new LandingPage(driver);
        landinPage.getLandingPage();
        landinPage.clickMytickets().checkLoginPageOpened();

    }

    @Test
    public void checkKnowledgeBaseWithoutLogin(){
        landingPage = new LandingPage(driver);
        landingPage.getLandingPage();
        landingPage.getKnowledgeBase().checkLoginPageOpened();

    }


    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void createTestTicketWithSelectedAreas() throws InterruptedException {
        newTicketPage = new NewTicketPage(driver);

        newTicketPage.getTicketCreate();
        newTicketPage.fillUserDetails(
                "mustafa@yopmail.com",
                "mustafa",
                "karatas",
                "90",
                "5434593612",
                "123");

        //ticket option selects
        newTicketPage.selectHelpTopic("suppor1t query");
        newTicketPage.selectStatus("open");
        newTicketPage.selectDepartment("support");
        newTicketPage.selectSlaPlan("6 hours");
        newTicketPage.selectAssignToAgent("demo admin");
        newTicketPage.selectLocation("testbug");
        newTicketPage.selectTicketType("test type");

        newTicketPage.fillTicketDetail("Test Subject for Automation", "Test detail");
        newTicketPage.selectPriority("normal");
//        newTicketPage.createTicket();
    }

    @Test
    void loginViaRedirect(){
        landingPage = new LandingPage(driver);
        landingPage
                .getLanding()
                .getLoginPage()
                .getDashboardWithStaffLogin(TEST_EMAIL,TEST_PWD)
                .checkDashboardOpened();

    }

    MyTicketsPage myTicketsPage;
    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void getTextOnTicketTable(){
        myTicketsPage = new MyTicketsPage(driver);
        dashboardPage = new DashboardPage(driver);
        dashboardPage.getMyTicketsPage().writeTable();
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
        ticketInboxPage.getTicketInboxPage().getTicketDetailsPage().closeTicketDetail("BEYZOŞ");
    }

    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void addReplyToTicketTest(){
        ticketInboxPage = new TicketInboxPage(driver);
        ticketInboxPage.getTicketInboxPage().getTicketDetailsPage().addReplyToTicket("Test Reply");
    }

    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void addInternalNoteToTicketTest(){
        ticketInboxPage = new TicketInboxPage(driver);
        ticketInboxPage.getTicketInboxPage().getTicketDetailsPage().addInternalNoteToTicket("Test Internal Note");
    }









}

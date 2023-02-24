package org.testapp.Ui.Test;

import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Pages.Faveo.*;
import org.testapp.Ui.Pages.Faveo.AdminPanel.AdminPanelDashboardPage;
import org.testapp.Ui.Pages.Faveo.Client.TicketCreatePage;
import org.testapp.Ui.Test.TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
//@Listeners(TestListener.class)
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
        adminPanelDashboardPage = new AdminPanelDashboardPage(driver);
        adminPanelDashboardPage.getStatusPage().createStatus("Delete", "3","#f1627e" );

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

//        newTicketPage.fillTicketDetail("Test Subject for Automation", "Test detail");
//        newTicketPage.createTicket();
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

//        newTicketPage.selectDepartment("support");
//        newTicketPage.fillTicketDetail("Test Subject for Automation", "Test detail");
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

    AdminPanelDashboardPage adminPanelDashboardPage;
    @Test (priority = 4)
    public void redirectToAdminPanelAfterLogin(){
        adminPanelDashboardPage = new AdminPanelDashboardPage(driver);
        adminPanelDashboardPage.getAdminPanelDashboardPage();

        boolean adminPanelOpenedStatus = adminPanelDashboardPage.isAdminPanelDashboardPageOpened();

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
        adminPanelDashboardPage = new AdminPanelDashboardPage(driver);
        adminPanelDashboardPage.getAdminPanelDashboardPage();
        adminPanelDashboardPage.checkAdminPanelOpened();
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

//        newTicketPage.selectHelpTopic("suppor1t query");
//        newTicketPage.selectStatus("open");
//        newTicketPage.selectDep2(1);
//        newTicketPage.selectDepartment("support");
//        newTicketPage.selectSlaPlan("6 hours");
//        newTicketPage.selectAssignToAgent("demo admin");
//        newTicketPage.selectLocation("testbug");
//        newTicketPage.selectTicketType("test type");
//
//        newTicketPage.fillTicketDetail("Test Subject for Automation", "Test detail");
//        newTicketPage.selectPriority("normal");
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
        ticketInboxPage.getTicketInboxPage().getTicketDetailsPage().closeTicketDetail("test");
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


    //create test ticket

    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void createTestTicketWithValidCredentials(){
        newTicketPage = new NewTicketPage(driver);

        newTicketPage.getTicketCreate();
        newTicketPage.fillUserDetails(
                "mustafa@yopmail.com",
                "mustafa",
                "karatas",
                "90",
                "5434593612",
                "123");

//        newTicketPage.fillTicketDetail("Test Subject for Automation", "Test detail");
//        newTicketPage.createTicket();
    }


    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void checkTicketInboxPageViaUrl(){
        ticketInboxPage = new TicketInboxPage(driver);
        ticketInboxPage
                .getTicketInboxPage()
                .getTicketDetailsPage()
                .checkTicketDetailsPageOpened();
    }

    @Test(dependsOnMethods = {"staffLoginWithValidCredentials"})
    public void addTimeToTicket() throws InterruptedException {

        /*
        there must'n be any work time

        * login
        * ticket inbox
        * edit ticket detail
        * add work time to ticket */
        ticketInboxPage = new TicketInboxPage(driver);
        ticketInboxPage
                .getTicketInboxPage()
                .getTicketDetailsPage()
                .addWorkTime("1", "1", "Test Description");





    }

    private String CLIENT_EMAIL = PropertyManager.getInstance().getTestClientEmail();
    private String CLIENT_PASSWORD = PropertyManager.getInstance().getTestClientPassword();
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

    @Test(dependsOnMethods = {"clientLogin"})
    public void clientLogOut(){
        homePage = new HomePage(driver);
        homePage.signOutFromHomePage();
    }














}

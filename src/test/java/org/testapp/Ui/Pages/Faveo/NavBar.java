package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class NavBar extends BasePage {
    private By profileNavbarButtonLocator = By.xpath("/html/body/div[1]/aside/div/div[4]/div/div/div");
    private By inboxNavbarButtonLocator = By.id("load-inbox");
    private By myTicketsNavbarButtonLocator = By.id("load-myticket");
    private By unassignedNavbarButtonLocator = By.xpath("//aside[@class='main-sidebar elevation-4 sidebar-dark-lightblue']//li[4]//a[1]");
    private By NavbarButtonLocator = By.xpath("//aside[@class='main-sidebar elevation-4 sidebar-dark-lightblue']//li[5]//a[1]");
    private By trashNavbarButtonLocator = By.cssSelector("li:nth-child(6) a:nth-child(1)");

    private TicketInboxPage ticketInboxPage;
    private ProfilePage profilePage;
    private MyTicketsPage myTicketsPage;
    public NavBar(WebDriver driver) {
        super(driver);
    }
    public TicketInboxPage getTicketInboxPage(){
        click(inboxNavbarButtonLocator);
        if(ticketInboxPage == null){
            ticketInboxPage = new TicketInboxPage(driver);
        }
        return ticketInboxPage;
    }

    public ProfilePage getProfilePage(){
        click(profileNavbarButtonLocator);
        if(profilePage == null){
            profilePage = new ProfilePage(driver);
        }
        return profilePage;
    }

    public MyTicketsPage getMyTicketsPage(){
        click(myTicketsNavbarButtonLocator);
        if(myTicketsPage == null){
            myTicketsPage = new MyTicketsPage(driver);
        }
        return myTicketsPage;
    }


}

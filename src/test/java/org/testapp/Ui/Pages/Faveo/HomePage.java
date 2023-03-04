package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testapp.Ui.Pages.BasePage;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {


    private By logOutDropdownButtonLocator = By.xpath("//a[contains(@class,'nav-link dropdown-toggle')]");
    private By signOutButton = By.xpath("//a[contains(.,'Sign Out')]");








    private By myProfileDropDownLocator = By.xpath("//*[@id=\"navbarDropdown\"]");


/*    private By dropdownDashboardButtonLocator = By.xpath("//*[@id=\"dropdown_content\"]/a[2]");

    private By dropdownLogoutButtonLocator = By.cssSelector("#dropdown_content > a:nth-child(1)");*/

//    List<WebElement> dropdownElements = driver.findElements(myProfileDropDownLocator);

    private By dashboardButtonLocator = By.xpath("//*[@id=\"dropdown_content\"]/a[2]");



/*
    private By dropDownContent = By.id("dropdown_content");
    Select dropdown = new Select(findBy(dropDownContent));

*/

    private By profileDropdownLoc = By.xpath("//*[@id=\"navbarDropdown\"]");
    private By dashboardLoc = By.xpath("//*[@id=\"dropdown_content\"]/a[2]");


    //client page elements
    private By submitTicketButtonLocator = By.xpath("//*[@id=\"wbox\"]/span[1]/a");
    private By myTicketsButtonLocator = By.xpath("//*[@id=\"wbox\"]/span[2]/a");
    private By knowledgeBaseButtonLocator = By.xpath("//*[@id=\"wbox\"]/span[3]/a");

    private By getMyProfileDropDownLocator2 = By.xpath("//a[contains(.,'My profile')]");
    private By logOutButtonLocator = By.xpath("//*[@id=\"dropdown_content\"]/a[1]");



    DashboardPage dashboardPage;
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    public void signOut(){
        click(logOutDropdownButtonLocator);
        click(signOutButton);
    }

    public DashboardPage getDashboardPage(){
        click(profileDropdownLoc);
        click(dashboardLoc);
        return dashboardPage = new DashboardPage(driver);
    }

    public void logout(){
        click(myProfileDropDownLocator);
//        click(dropdownLogoutButtonLocator);
    }
    public void signOutFromHomePage(){
        click(getMyProfileDropDownLocator2);
        click(logOutButtonLocator);
    }


    public void homePageOpened(){
        Assert.assertEquals(isDisplayed(myProfileDropDownLocator), true, "Home Page is not opened");
    }

}

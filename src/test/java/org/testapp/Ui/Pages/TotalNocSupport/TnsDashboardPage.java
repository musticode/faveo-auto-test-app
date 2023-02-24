package org.testapp.Ui.Pages.TotalNocSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TnsDashboardPage extends BasePage{

    private By myDashboardButtonLocator = By.xpath("//a[@tabindex='0'][contains(.,'My Dashboard')]");
    private By profileButtonLocator = By.xpath("//a[@tabindex='0'][contains(.,'Profile')]");


    private By logOutButtonDropDownLocator = By.xpath("//i[@class='v-icon notranslate v-icon--right mdi mdi-chevron-down theme--dark']");
    private By logOutButtonLocator = By.xpath("//div[@tabindex='-1'][contains(.,'Logout')]");



    public TnsDashboardPage(WebDriver driver) {
        super(driver);
    }


    public void logOut(){
        click(logOutButtonDropDownLocator);
        click(logOutButtonLocator);
    }

    public boolean isTnsDashBoardPageOpened(){
        return isDisplayed(myDashboardButtonLocator);
    }





}

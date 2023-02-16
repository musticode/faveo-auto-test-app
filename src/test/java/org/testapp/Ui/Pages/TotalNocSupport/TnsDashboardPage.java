package org.testapp.Ui.Pages.TotalNocSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TnsDashboardPage extends BasePage{

    private By myDashboardButtonLocator = By.xpath("//a[@tabindex='0'][contains(.,'My Dashboard')]");
    private By profileButtonLocator = By.xpath("//a[@tabindex='0'][contains(.,'Profile')]");



    public TnsDashboardPage(WebDriver driver) {
        super(driver);
    }


    public boolean isTnsDashBoardPageOpened(){
        return isDisplayed(myDashboardButtonLocator);
    }





}

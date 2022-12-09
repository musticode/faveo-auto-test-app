package org.testapp.Ui.Pages.Sdv2;

import org.openqa.selenium.WebDriver;
import org.testapp.Ui.DataProvider.PropertyManager;
import org.testapp.Ui.Pages.TotalNocSupport.BasePage;

public class Sdv2MainPage extends BasePage {
    String APP_URL = PropertyManager.getInstance().getAppUrl();

    //page objects


    public Sdv2MainPage(WebDriver driver) {
        super(driver);
    }

    public void getMainPage(){
        driver.get(APP_URL);
    }







}

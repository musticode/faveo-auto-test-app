package org.testapp.Ui.Pages.TotalNocSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TnsMainPage extends BasePage{
    private final String TNS_MAIN_URL = "https://staging-cloudmsp.ctrl.comodo.com/";



    public TnsMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getMainPage(){
        driver.get(TNS_MAIN_URL);
    }


}

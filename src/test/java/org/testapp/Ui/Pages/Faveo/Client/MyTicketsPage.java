package org.testapp.Ui.Pages.Faveo.Client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;
import org.testapp.Ui.Test.TestBase.BaseTest;

public class MyTicketsPage extends BasePage {



    public MyTicketsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MyTicketsPage getMyTicketsPage(){
        driver.get(APP_URL.concat("/mytickets"));
        return this;
    }


}

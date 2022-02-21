package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;

public class Header extends BasePage {


    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}

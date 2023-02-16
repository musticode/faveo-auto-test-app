package org.testapp.Ui.Pages.Pair;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class MainPage extends BasePage {
    private By availableStatusButtonLocator = By.cssSelector("#status1");
    private By breakStatusButtonLocator = By.cssSelector("#status6");
    private By lunchStatusButtonLocator = By.cssSelector("#status7");


    public MainPage(WebDriver driver) {
        super(driver);
    }
}

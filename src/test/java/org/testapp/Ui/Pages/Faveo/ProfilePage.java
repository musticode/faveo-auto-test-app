package org.testapp.Ui.Pages.Faveo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;
import org.testng.Assert;

public class ProfilePage extends BasePage {
    private By profilePageH1 = By.xpath("/html/body/div[1]/div[1]/div[3]/div/div/div[1]/h1[2]");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Get profile page with url")
    public void getProfilePage(){
        driver.get(APP_URL.concat("/profile"));
    }

    @Step("Assertion")
    public void checkProfilePageOpened(){
        Assert.assertEquals(getText(profilePageH1), "View profile","Profile page is not opened");
    }
}

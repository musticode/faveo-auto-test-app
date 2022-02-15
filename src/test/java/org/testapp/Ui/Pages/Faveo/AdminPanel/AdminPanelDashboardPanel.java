package org.testapp.Ui.Pages.Faveo.AdminPanel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class AdminPanelDashboardPanel extends BasePage {

    private By adminPanelTextLocator = By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/h1[2]");

    public AdminPanelDashboardPanel(WebDriver driver) {
        super(driver);
    }
    @Step("Get admin panel with redirection")
    public AdminPanelDashboardPanel getAdminPanelDashboardPage(){
        driver.get(APP_URL.concat("/admin"));
        return this;
    }
    @Step("is admin panel opened")
    public boolean isAdminPanelDashboardPageOpened(){
        return getText(adminPanelTextLocator).equalsIgnoreCase("Adminaa Panel");
    }

}

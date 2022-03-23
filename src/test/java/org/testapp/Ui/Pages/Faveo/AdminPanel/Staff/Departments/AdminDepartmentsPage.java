package org.testapp.Ui.Pages.Faveo.AdminPanel.Staff.Departments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;

// about:blank
public class AdminDepartmentsPage extends BasePage {

    //page objects
    @FindBy(css = "aa")
    public WebElement el;

    private By createDepartmentLocator = By.id("a");


    public AdminDepartmentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("get department page")
    public AdminDepartmentsPage getTeamsPage(){
        getPage("/");
        return this;
    }

    @Step("get department create page via clicking create department locator")
    public DepartmentCreatePage getDepartmentCreatePage(){
        click(createDepartmentLocator);
        return new DepartmentCreatePage(driver);
    }

}
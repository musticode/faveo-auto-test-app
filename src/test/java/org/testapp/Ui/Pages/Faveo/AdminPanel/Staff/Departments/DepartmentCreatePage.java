package org.testapp.Ui.Pages.Faveo.AdminPanel.Staff.Departments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;

public class DepartmentCreatePage extends BasePage {

    //page objects


    public DepartmentCreatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //page functions
    public DepartmentCreatePage getDepartmentCreatePage(){
        getPage("/departments");
        return this;
    }

    public DepartmentCreatePage createDepartment(){
        return this;
    }

    public DepartmentCreatePage editDepartment(){
        return this;
    }


}

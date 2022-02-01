package org.testapp.Ui.Pages.DemoQAPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class WebTablesRegistrationForm extends BasePage {
    private By firstNameLocator = By.id("firstName");
    private By lastNameLocator = By.id("lastName");
    private By emailLocator = By.id("userEmail");
    private By ageLocator = By.id("age");
    private By salaryLocator = By.id("salary");
    private By departmentLocator = By.id("department");
    private By submitButtonLocator = By.id("submit");

    public void fillRegistrationForm(String firstName,
                                     String lastName,
                                     String email,
                                     String age,
                                     String salary,
                                     String department){
        setText(firstNameLocator, firstName);
        setText(lastNameLocator, lastName);
        setText(emailLocator, email);
        setText(ageLocator, age);
        setText(salaryLocator, salary);
        setText(departmentLocator, department);
        click(submitButtonLocator);
    }


    public WebTablesRegistrationForm(WebDriver driver) {
        super(driver);
    }
}

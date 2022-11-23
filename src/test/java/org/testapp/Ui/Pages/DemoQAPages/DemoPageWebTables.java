package org.testapp.Ui.Pages.DemoQAPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

import java.util.ArrayList;

public class DemoPageWebTables extends BasePage {
    private final String DEMO_WEB_TABLES_PAGE_URL = "https://demoqa.com/webtables";
    private By addNewRecordButton = By.id("addNewRecordButton");
    private By table = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]");


    private WebTablesRegistrationForm webTablesRegistrationForm;
    public DemoPageWebTables(WebDriver driver) {
        super(driver);
        driver.get(DEMO_WEB_TABLES_PAGE_URL);
    }
    public WebTablesRegistrationForm getWebTablesRegistrationForm(){
        click(addNewRecordButton);
        return new WebTablesRegistrationForm(driver);
    }
    public String getTableText(){
        return getText(table);
    }
    public ArrayList tableList(){
        ArrayList<String> table = new ArrayList<String>();
        table.add(getTableText());

        return table;
    }



}
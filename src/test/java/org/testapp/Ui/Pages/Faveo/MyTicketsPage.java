package org.testapp.Ui.Pages.Faveo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;
import org.testng.Assert;

import java.util.List;

public class MyTicketsPage extends BasePage {
    private By myTicketsTableNameLocator = By.xpath("//h3[normalize-space()='My tickets']");

    private By subjectTable = By.xpath("//*[@id=\"chumper_wrapper\"]");

    List<WebElement> table = driver.findElements(subjectTable);



    public MyTicketsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void writeTable(){
        int columnSize = table.size();
        System.out.println("size: "+columnSize);


        for(int i =0; i< table.size(); i++){
            System.out.println(table.get(i).getText());
        }
    }





    @Step("Check My Ticket page is opened")
    public void checkMyticketsPageOpened(){
        Assert.assertEquals(getText(myTicketsTableNameLocator),"My tickets","My tickets page is not opened");
    }
}

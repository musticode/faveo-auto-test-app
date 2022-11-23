package org.testapp.Ui.Pages.Faveo.AdminPanel.Manage.Priority;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;

import java.util.List;

public class PriorityPage extends BasePage {
    //page objects
    private By createPriorityButtonLocator = By.xpath("//a[@class='btn btn-default btn-tool']");


    //sırası değişebilen table
    private By lowTestUpdatePriorityEditButtonLocator = By.xpath("//tbody/tr[4]/td[5]/a[1]");


    /* priority table

    // //*[@id="chumper"]/tbody/tr[1]

    private By priorityTable = By.xpath("//*[@id=\"chumper\"]/tbody/tr");
    // //*[@id="chumper"]/tbody/tr


    public void find() {
        List<WebElement> rowsPr = driver.findElements(priorityTable);
        int size = rowsPr.size();

        for (int i = 0; i < size; i++) {
            System.out.println(rowsPr.get(i).getText());

        }
    }


     */


    public PriorityPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open priority page")
    public PriorityPage getPriorityPage(){
        getPage("/ticket/priority");
        return this;
    }

    @Step("Open priority page via clicking create priority button")
    public PriorityCreatePage getPriorityCreatePage(){
        click(createPriorityButtonLocator);
        return new PriorityCreatePage(driver);
    }

    @Step("Open priority create page via edit button")
    public PriorityCreatePage editPriority(){
        click(lowTestUpdatePriorityEditButtonLocator);
        return new PriorityCreatePage(driver);
    }







}

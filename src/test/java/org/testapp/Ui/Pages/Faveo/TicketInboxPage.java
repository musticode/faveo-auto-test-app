package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testapp.Ui.Pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TicketInboxPage extends BasePage {
    private By ticketTable = By.xpath("//*[@id=\"chumper\"]/tbody");

    private By testTicketNameInTable = By.xpath("//tbody/tr[1]/td[2]/div[1]/a[1]");


    @FindBy(xpath = "//tr[@name='vtl-group-0']")
    private List<WebElement> tableColumns;

    @FindBy(xpath = "//td[@class='vtl-tbody-td']")
    private List<WebElement> tableElements;



    private TicketDetailsPage ticketDetailsPage;

    public TicketInboxPage(WebDriver driver) {
        super(driver);

    }

    public void navigateToTicketDetailsWithElementIndex(int index){
        tableElements = new ArrayList<>();
        clickGeneric(tableElements.get(index));

    }




    public TicketInboxPage getTicketInboxPage(){
        driver.get(APP_URL.concat("/ticket/inbox"));
        return this;
    }

    public TicketDetailsPage getTicketDetailsPage(){
        click(testTicketNameInTable);
        return new TicketDetailsPage(driver);
    }


    public String getTableElements(){
        return getText(ticketTable);
    }

    public void checkTable(String ticketSubject){
        char [] array = getTableElements().toCharArray();
        for(char a : array){
            System.out.print(a);
        }
    }
}



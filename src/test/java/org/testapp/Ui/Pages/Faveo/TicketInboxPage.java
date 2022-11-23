package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class TicketInboxPage extends BasePage {
    private By ticketTable = By.xpath("//*[@id=\"chumper\"]/tbody");

    private By testTicketNameInTable = By.xpath("//tbody/tr[1]/td[2]/div[1]/a[1]");


    private TicketDetailsPage ticketDetailsPage;

    public TicketInboxPage(WebDriver driver) {
        super(driver);

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



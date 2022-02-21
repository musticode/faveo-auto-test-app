package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class TicketInboxPage extends BasePage {
    private By ticketTable = By.xpath("//*[@id=\"chumper\"]/tbody");


    public TicketInboxPage(WebDriver driver) {
        super(driver);
        driver.get(APP_URL.concat("/ticket/inbox"));
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

package org.testapp.Ui.Pages.DemoQAPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Pages.BasePage;

public class DemoPageRadio extends BasePage {
    private final String DEMO_PAGE_RADIO ="https://demoqa.com/radio-button";
    private By yesRadioButtonLocator = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]");
    private By impressiveRadioButton = By.cssSelector("div[class='col-12 mt-4 col-md-6'] div:nth-child(3)");
    private By selectedAreaLocator = By.cssSelector(".mt-3");

    public DemoPageRadio(WebDriver driver) {
        super(driver);
        driver.get(DEMO_PAGE_RADIO);
    }
    public void clickRadioButton(String buttonName){
        if (buttonName.equalsIgnoreCase("yes")){
            click(yesRadioButtonLocator);
        }else{
            click(impressiveRadioButton);
        }
    }
    public String getClickedRadioButton(){
        return getText(selectedAreaLocator);
    }


}

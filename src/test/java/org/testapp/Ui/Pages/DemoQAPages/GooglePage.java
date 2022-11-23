package org.testapp.Ui.Pages.DemoQAPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://testaccountmsp1.osticket.dmdemo.comodo.com/
public class GooglePage {

    @FindBy(xpath = "//a[contains(@style, 'news')]")
    public WebElement widgetrowitemLink;

    @FindBy(xpath = "//a[contains(@style, 'knowledgebase')]")
    public WebElement widgetrowitemLink2;

    @FindBy(css = ".nav-item.active a")
    public WebElement navlinkLink;

    @FindBy(css = "li[class='nav-item'] a")
    public WebElement navlinkLink2;

    @FindBy(id = "navbarDropdown")
    public WebElement navbarDropdownLink;

    @FindBy(id = "load-inbox")
    public WebElement loadinboxLink;

    @FindBy(xpath = "//a[text()='Admin Panel']")
    public WebElement navlinkLink3;

    @FindBy(css = "i[class~='fa']")
    public WebElement fasI;

    @FindBy(css = ".btn-tool")
    public WebElement btnLink;

    @FindBy(id = "name")
    public WebElement nameInput;

    @FindBy(css = ".col-sm-2")
    public WebElement colsm2Div;

    @FindBy(id = "sla")
    public WebElement slaSelect;

    @FindBy(xpath = "//option[text()='6 Hours']")
    public WebElement elementOption;

    public GooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
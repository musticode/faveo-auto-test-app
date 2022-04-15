package org.testapp.Ui.Pages.Faveo.AdminPanel.Staff.Teams;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;

public class TeamCreatePage extends BasePage{
    //page objects
    private By teamNameInputLocator = By.id("name");
    private By adminNotesInputTextLocator = By.xpath("/html/body/div[1]/div[1]/section[2]/form/div/div[2]/div[2]/div/div[3]/div[2]");
    private By submitButtonLocator = By.cssSelector("input[value='Submit']");
    private By editSubmitButtonLocator = By.cssSelector("input[value='Update']");

    public TeamCreatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //page functions
    @Step("create team with {name} {adminNotes}")
    public TeamCreatePage createTeam(String name, String adminNotes){
        setText(teamNameInputLocator, name);
        setText(adminNotesInputTextLocator, adminNotes);
//        click(submitButtonLocator);
        return this;
    }

    @Step("edit team with {name} {adminNotes}")
    public TeamCreatePage editTeam(String name, String adminNotes){
        setText(teamNameInputLocator, name);
        setText(adminNotesInputTextLocator, adminNotes);
//        click(editSubmitButtonLocator);
        return this;
    }

    @Step("get create team page")
    public TeamCreatePage getCreateTeamPage(){
        getPage("/teams/create");
        return this;
    }

}

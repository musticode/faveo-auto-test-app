package org.testapp.Ui.Pages.Faveo.AdminPanel.Staff.Teams;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testapp.Ui.Pages.BasePage;
import org.testng.Assert;

public class TeamsPage extends BasePage {
    //page objects
    private By createTeamButtonLocator = By.xpath("//a[@class='btn btn-default btn-tool']");

    private By showButtonLocator = By.xpath("//tbody/tr[2]/td[5]/form[1]/a[1]");
    private By editTeamButtonLocator = By.xpath("//tbody/tr[2]/td[5]/form[1]/a[2]");
    private By deleteTeamButtonLocator = By.xpath("//tbody/tr[2]/td[5]/form[1]/button[1]");

    //assertion objects
    private By teamsH1TextTitle = By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/h1[2]");




    public TeamsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    //page functions
    @Step("Get teams page")
    public TeamsPage getTeamsPage(){
        getPage("/teams");
        return this;
    }

    @Step("create team")
    public TeamCreatePage getCreateTeamPage(){
        click(createTeamButtonLocator);
        return new TeamCreatePage(driver);
    }

    @Step("Show action button click")
    public TeamsPage showAction(){
        click(showButtonLocator);
        return this;
    }

    @Step("Edit team")
    public TeamCreatePage editTeamInActions(){
        click(editTeamButtonLocator);
        return new TeamCreatePage(driver);
    }

    @Step("Delete team")
    public TeamsPage deleteTeam(){
        click(deleteTeamButtonLocator);
        return this;
    }

    //assertion functions
    @Step("Is teams page opened")
    public TeamsPage checkTeamsPageOpened(){
        Assert.assertEquals(getText(teamsH1TextTitle), "Teams", "Teams page is not opened");
        return this;
    }



}

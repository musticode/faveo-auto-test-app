package org.testapp.Ui.Test.Sdv2Tests;

import org.testapp.Ui.Pages.Sdv2.Sdv2LoginPage;
import org.testapp.Ui.Pages.Sdv2.Sdv2MainPage;
import org.testng.annotations.Test;

public class Sdv2MainPageTest extends BaseTest{
    Sdv2MainPage sdv2MainPage;

    Sdv2LoginPage sdv2LoginPage;

    @Test
    public void getMainPage(){
        sdv2MainPage = new Sdv2MainPage(driver);
        sdv2MainPage.getMainPage();
    }

    @Test
    public void staffLoginTest(){
        sdv2LoginPage = new Sdv2LoginPage(driver);
        sdv2LoginPage.getLoginPage();
        sdv2LoginPage.staffLogin("testaccount21nov@yopmail.com", "Comodo456*");
    }
}

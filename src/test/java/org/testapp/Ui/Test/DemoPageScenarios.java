package org.testapp.Ui.Test;

import io.qameta.allure.Description;
import org.testapp.Ui.Listener.TestListener;
import org.testapp.Ui.Pages.DemoQAPages.DemoPageRadio;
import org.testapp.Ui.Pages.DemoQAPages.DemoPageTextBox;
import org.testapp.Ui.Pages.DemoQAPages.DemoPageWebTables;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestListener.class)
public class DemoPageScenarios extends BaseRemoteTest{
    String FULL_NAME = "Mustafa";
    String EMAIL = "test@yopmail.com";
    String CURRENT_ADDRESS = "current address";
    String PARMANENT_ADDRESS = "parmanent address";

    DemoPageTextBox demoPageTextBox;
    @Test(priority = 0)
    @Description("Demo Page text box test")
    public void textBoxTest(){
        demoPageTextBox = new DemoPageTextBox(getDriver());
        demoPageTextBox.fillTextBox(FULL_NAME, EMAIL, CURRENT_ADDRESS, PARMANENT_ADDRESS);
        demoPageTextBox.submit();
        System.out.println(demoPageTextBox.getOutput());

        Assert.assertEquals(demoPageTextBox.getOutput(),
                "Name:"+FULL_NAME+"\n" +
                "Email:"+EMAIL+"\n" +
                "Current Address :"+CURRENT_ADDRESS+"\n" +
                "Permananet Address :"+PARMANENT_ADDRESS,
                "Not matching with output");
    }


    DemoPageRadio demoPageRadio;
    @Test(priority = 1)
    @Description("Radio button page: Yes radio button test")
    public void radioButtonTest(){
        demoPageRadio = new DemoPageRadio(getDriver());
        demoPageRadio.clickRadioButton("yes");
        System.out.println(demoPageRadio.getClickedRadioButton());

        Assert.assertEquals(demoPageRadio.getClickedRadioButton(),
                "You have selected Yes",
                "Yes Radio button is not selected");

    }

    @Test(priority = 2)
    @Description("Radio button page: Impressive radio button test")
    public void radioButtonTest2_ImpressiveButtonSelected(){
        demoPageRadio = new DemoPageRadio(getDriver());
        demoPageRadio.clickRadioButton("impressive");
        System.out.println(demoPageRadio.getClickedRadioButton());

        Assert.assertEquals(demoPageRadio.getClickedRadioButton(),
                "You have selected Impressive",
                "Yes Radio button is not selected");
    }

    DemoPageWebTables demoPageWebTables;
    @Test(priority = 3)
    public void demoPageWebTablesTest1(){
        demoPageWebTables = new DemoPageWebTables(getDriver());
        demoPageWebTables
                .getWebTablesRegistrationForm()
                .fillRegistrationForm(FULL_NAME,"Karatas", EMAIL, "13","123","eng");
        System.out.println(demoPageWebTables.getTableText());


    }


}

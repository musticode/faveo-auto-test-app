package org.testapp.Ui.Test;

import org.testapp.Ui.Pages.DemoQAPages.DemoPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testapp.Ui.Test.TestBase.BaseTestSelenoid;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestWithSelenoid extends BaseTestFactory {

    DemoPage demoPage;
    @Test
    void test1() throws MalformedURLException {
        demoPage = new DemoPage(driver);
        demoPage.openPage();
    }



}

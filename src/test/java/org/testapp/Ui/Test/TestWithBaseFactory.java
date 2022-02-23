package org.testapp.Ui.Test;

import org.testapp.Ui.Pages.DemoQAPages.DemoPage;
import org.testapp.Ui.Test.TestBase.BaseTestFactory;
import org.testng.annotations.Test;

public class TestWithBaseFactory extends BaseTestFactory {
    DemoPage demoPage;
    @Test
    void test1(){
        demoPage = new DemoPage(driver);
        demoPage.openPage();
    }
}

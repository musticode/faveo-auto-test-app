package org.testapp.Api.DataProvider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "msp-request-data")
    public Object[][] mspRequestDataProvider(){
        return new Object[][]{
                {"must1"},
                {"must2"}
        };
    }

}

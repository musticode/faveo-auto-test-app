package org.testapp.Api.Test;

import org.testapp.Api.DataProvider.DataGenerator.FakeDataGenerator;
import org.testapp.Api.PropertyManager.PropertyManager;
import org.testng.annotations.Test;

public class TestThreadSleep {

    private String API_KEY = PropertyManager.getInstance().getApiKey();
    private String APP_URL = PropertyManager.getInstance().getUrl();
    static private String MSP_ID = PropertyManager.getInstance().getMspId();
    private String ID = PropertyManager.getInstance().getId();
    private String COMPANY_ID = PropertyManager.getInstance().getCompanyId();
    private String STAFF_UNIQUE_ID = PropertyManager.getInstance().getStaffUniqueId();
    private String USER_UNIQUE_ID = PropertyManager.getInstance().getUserUniqueId();


    //fake data
    static FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();
    static String fakeMspId  = fakeDataGenerator.fakeMsp(MSP_ID);
    static String fakeCompanyId = fakeDataGenerator.fakeCompany();
    static String fakeStaffUniqueUserId = fakeDataGenerator.fakeStaffUniqueUser();

    @Test
    public void testString() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("fake msp id: " + fakeMspId);
        System.out.println("fake company id: " + fakeCompanyId);
        System.out.println("fake staff unique user id:" + fakeStaffUniqueUserId);
    }

    @Test
    public void testString2() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("fake msp id: " + fakeMspId);
        System.out.println("fake company id: " + fakeCompanyId);
        System.out.println("fake staff unique user id:" + fakeStaffUniqueUserId);
    }

    @Test
    public void testString3() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("fake msp id: " + fakeMspId);
        System.out.println("fake company id: " + fakeCompanyId);
        System.out.println("fake staff unique user id:" + fakeStaffUniqueUserId);
    }



}

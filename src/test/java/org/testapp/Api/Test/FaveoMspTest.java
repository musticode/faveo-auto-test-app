package org.testapp.Api.Test;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.jayway.restassured.response.ValidatableResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.hamcrest.core.IsEqual;
import org.testapp.Api.DataProvider.DataGenerator.DataGenerator;
import org.testapp.Api.DataProvider.DataGenerator.FakeDataGenerator;
import org.testapp.Api.DataProvider.Pim.*;
import org.testapp.Api.PropertyManager.PropertyManager;
import org.testapp.Api.RestClient.RestClientValidatableResponse;
import org.testapp.Ui.Listener.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.jayway.restassured.RestAssured.given;
//@Listeners(TestListener.class)
public class FaveoMspTest {
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
    public void testString(){
        System.out.println("fake msp id: "+fakeMspId);
        System.out.println("fake company id: "+fakeCompanyId);
        System.out.println("fake staff unique user id:" +fakeStaffUniqueUserId);


//        String ciguli = DataGenerator.getDataGenerator().getRandomData();
//        System.out.println(ciguli);

    }
    @Test
    public void testString2(){
        System.out.println(fakeMspId);

    }



    RequestUrl requestUrl = new RequestUrl();
    ValidatableResponse response;
    MspRequestBody mspRequestBody;
    AdminRequestBody adminRequestBody;
    CompanyRequestBody companyRequestBody;
    RoleRequestBody roleRequestBody;
    StaffRequestBody staffRequestBody;

    UserRequestBody userRequestBody;

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Creating MSP with POST operation")
    public void createMsp(){
        mspRequestBody= new MspRequestBody();
/*        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer "+API_KEY)
                .body(mspRequestBody.getMspCreateRequestBody("test"))
                .post(APP_URL.concat("/pim/msps"))
                .then();

        response.log().body().extract().asString();*/

        response =
                RestClientValidatableResponse
                .doPost(requestUrl.getMspCreateRequestUrl(),
                mspRequestBody.getMspCreateRequestBody(fakeMspId));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        //response.assertThat().body("data.msp_id", IsEqual.equalTo(MSP_ID));
        response.assertThat().body("message", IsEqual.equalTo("MSP Created"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Update MSP with PATCH operation")
    public void updateMsp() throws InterruptedException {
        Thread.sleep(10000);
        mspRequestBody= new MspRequestBody();
        response = RestClientValidatableResponse.doPatch(requestUrl.getMspUpdateRequestUrl(),
                mspRequestBody.getMspUpdateBody(fakeMspId));

        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("MSP Updated"));


    }
    @Test(priority = 2)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Hold MSP with PATCH operation")
    public void holdMsp() throws InterruptedException {
        Thread.sleep(10000);
        mspRequestBody= new MspRequestBody();
        response = RestClientValidatableResponse.doPatch(requestUrl.getMspHoldRequestUrl(),
                mspRequestBody.getMspHoldBody(fakeMspId));
        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("MSP Disabled"));
//        response.assertThat().body("data.msp_id", IsEqual.equalTo(MSP_ID));


    }
    @Test(priority = 3)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Unhold MSP with PATCH operation")
    public void unholdMsp() throws InterruptedException {
        Thread.sleep(10000);
        mspRequestBody= new MspRequestBody();
        response = RestClientValidatableResponse.doPatch(requestUrl.getMspUnholdRequestUrl(),
                mspRequestBody.getMspUnholdRequestBody(fakeMspId));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("MSP Enabled"));
//        response.assertThat().body("data.msp_id", IsEqual.equalTo(MSP_ID));

    }
    @Test(priority = 4)
    @Severity(SeverityLevel.BLOCKER)
    @Description("create role")
    public void createRole()throws InterruptedException {
        Thread.sleep(10000);
        roleRequestBody = new RoleRequestBody();

        //sending request
        response = RestClientValidatableResponse.doPost(requestUrl.getRoleCreateRequestUrl(),
                roleRequestBody.getCreateRoleRequestBody(fakeMspId));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions beyzatest1auto23yvo6
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("Role Created"));

    }
    @Test(priority = 5)
    @Severity(SeverityLevel.BLOCKER)
    @Description("create admin")
    public void createAdmin()throws InterruptedException {
        Thread.sleep(10000);
        adminRequestBody = new AdminRequestBody();

        response = RestClientValidatableResponse.doPost(requestUrl.getAdminCreateRequestUrl(),
                adminRequestBody.getAdminCreateRequestBody(fakeMspId));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("Admin Created"));

    }
    @Test(priority = 6)
    @Severity(SeverityLevel.BLOCKER)
    @Description("create company")
    public void createCompany()throws InterruptedException {
        Thread.sleep(10000);
        companyRequestBody = new CompanyRequestBody();

        response = RestClientValidatableResponse.doPost(requestUrl.getCompanyCreateRequestUrl(),
                companyRequestBody.getCompanyCreateRequestBody(fakeMspId,fakeCompanyId));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("Company Created"));



    }
    @Test(priority = 7)
    @Severity(SeverityLevel.BLOCKER)
    @Description("update company")
    public void updateCompany()throws InterruptedException {
        Thread.sleep(10000);
        companyRequestBody = new CompanyRequestBody();

        response = RestClientValidatableResponse.doPatch(requestUrl.getCompanyUpdateRequestUrl(),
                companyRequestBody.getCompanyUpdateRequestBody(fakeMspId,fakeCompanyId));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("Company Updated"));


    }
    @Test(priority = 8)
    @Severity(SeverityLevel.BLOCKER)
    @Description("create staff")
    public void createStaff()throws InterruptedException {
        Thread.sleep(10000);
        staffRequestBody = new StaffRequestBody();

        response = RestClientValidatableResponse.doPost(requestUrl.getStaffCreateRequestUrl(),
                staffRequestBody.getStaffCreateRequestBody(fakeMspId,fakeStaffUniqueUserId));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("Admin Created"));



    //77638
    }
    @Test(priority = 9)
    @Severity(SeverityLevel.BLOCKER)
    @Description("update staff")
    public void updateStaff()throws InterruptedException {
        Thread.sleep(10000);
        staffRequestBody = new StaffRequestBody();

        response = RestClientValidatableResponse.doPatch(requestUrl.getStaffUpdateRequestUrl(),
                staffRequestBody.getStaffUpdateRequestBody(fakeMspId,fakeStaffUniqueUserId));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("Admin Updated"));

    }
    @Test(priority = 10)
    @Severity(SeverityLevel.BLOCKER)
    @Description("create user")
    public void createUser()throws InterruptedException {
        Thread.sleep(10000);
        userRequestBody = new UserRequestBody();

        response = RestClientValidatableResponse.doPost(requestUrl.getUserCreateRequestUrl(),
                userRequestBody.getUserCreateRequestBody(fakeMspId,fakeCompanyId,USER_UNIQUE_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("User Created"));

    }
    @Test(priority = 11)
    @Severity(SeverityLevel.BLOCKER)
    @Description("update user")
    public void updateUser()throws InterruptedException {
        Thread.sleep(10000);
        userRequestBody = new UserRequestBody();

        response = RestClientValidatableResponse.doPatch(requestUrl.getUserUpdateRequestUrl(),
                userRequestBody.getUserUpdateRequestBody(fakeMspId,fakeCompanyId,USER_UNIQUE_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions

    }
    @Test(priority = 12)
    @Severity(SeverityLevel.BLOCKER)
    @Description("delete user")
    public void deleteUser()throws InterruptedException {
        Thread.sleep(10000);
        userRequestBody = new UserRequestBody();

        response = RestClientValidatableResponse.doDelete(requestUrl.getUserDeleteRequestUrl(),
                userRequestBody.getUserDeleteRequestBody(fakeMspId,USER_UNIQUE_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
    }
    @Test(priority = 13)
    public void deleteStaff()throws InterruptedException {
        Thread.sleep(10000);
        staffRequestBody = new StaffRequestBody();

        response = RestClientValidatableResponse.doDelete(requestUrl.getStaffDeleteRequestUrl(),
                staffRequestBody.getStaffDeleteRequestBody(fakeMspId,fakeStaffUniqueUserId));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions

    }
    @Test(priority = 14)
    @Severity(SeverityLevel.BLOCKER)
    @Description("delete company")
    public void deleteCompany()throws InterruptedException {
        Thread.sleep(10000);
        companyRequestBody = new CompanyRequestBody();

        response = RestClientValidatableResponse.doDelete(requestUrl.getCompanyDeleteRequestUrl(),
                companyRequestBody.getCompanyDeleteRequestBody(fakeMspId,fakeCompanyId));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Delete MSP with DELETE operation")
    public void deleteMsp() throws InterruptedException {
        Thread.sleep(10000);
        mspRequestBody= new MspRequestBody();

        response = RestClientValidatableResponse.doDelete(requestUrl.getMspDeleteRequestUrl(),
                mspRequestBody.getMspDeleteRequestBody(fakeMspId));

        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("MSP Deleted"));

    }

}

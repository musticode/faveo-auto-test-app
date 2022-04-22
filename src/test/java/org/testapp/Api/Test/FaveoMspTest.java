package org.testapp.Api.Test;

import com.jayway.restassured.response.ValidatableResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.hamcrest.core.IsEqual;
import org.testapp.Api.DataProvider.DataGenerator.DataGenerator;
import org.testapp.Api.DataProvider.Pim.*;
import org.testapp.Api.PropertyManager.PropertyManager;
import org.testapp.Api.RestClient.RestClientValidatableResponse;
import org.testapp.Ui.Listener.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
//@Listeners(TestListener.class)
public class FaveoMspTest {
    private String API_KEY = PropertyManager.getInstance().getApiKey();
    private String APP_URL = PropertyManager.getInstance().getUrl();
    private String MSP_ID = PropertyManager.getInstance().getMspId();
    private String ID = PropertyManager.getInstance().getId();
    private String COMPANY_ID = PropertyManager.getInstance().getCompanyId();
    private String STAFF_UNIQUE_ID = PropertyManager.getInstance().getStaffUniqueId();
    private String USER_UNIQUE_ID = PropertyManager.getInstance().getUserUniqueId();

    //data generation for soft delete
    DataGenerator dateData = new DataGenerator();
//    String MSP_ID = mspId + dateData.getRandomData();




    @Test
    public void testString(){
        System.out.println(MSP_ID);

//        String ciguli = DataGenerator.getDataGenerator().getRandomData();
//        System.out.println(ciguli);

    }
    @Test
    public void testString2(){
        System.out.println(MSP_ID);

    }



    RequestUrl requestUrl = new RequestUrl();
    ValidatableResponse response;
    MspRequestBody mspRequestBody;
    AdminRequestBody adminRequestBody;
    CompanyRequestBody companyRequestBody;
    RoleRequestBody roleRequestBody;
    StaffRequestBody staffRequestBody;

    UserRequestBody userRequestBody;

    @Test
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
                mspRequestBody.getMspCreateRequestBody(MSP_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("data.msp_id", IsEqual.equalTo(MSP_ID));
        response.assertThat().body("message", IsEqual.equalTo("MSP Created"));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Update MSP with PATCH operation")
    public void updateMsp(){
        mspRequestBody= new MspRequestBody();
        response = RestClientValidatableResponse.doPatch(requestUrl.getMspUpdateRequestUrl(),
                mspRequestBody.getMspUpdateBody(MSP_ID));

        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("MSP Updated"));


    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Hold MSP with PATCH operation")
    public void holdMsp(){
        mspRequestBody= new MspRequestBody();
        response = RestClientValidatableResponse.doPatch(requestUrl.getMspHoldRequestUrl(),
                mspRequestBody.getMspHoldBody(MSP_ID));
        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("MSP Disabled"));
        response.assertThat().body("data.msp_id", IsEqual.equalTo(MSP_ID));


    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Unhold MSP with PATCH operation")
    public void unholdMsp(){
        mspRequestBody= new MspRequestBody();
        response = RestClientValidatableResponse.doPatch(requestUrl.getMspUnholdRequestUrl(),
                mspRequestBody.getMspUnholdRequestBody(MSP_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("MSP Enabled"));
        response.assertThat().body("data.msp_id", IsEqual.equalTo(MSP_ID));

    }
    @Test
    public void createRole(){
        roleRequestBody = new RoleRequestBody();

        //sending request
        response = RestClientValidatableResponse.doPost(requestUrl.getRoleCreateRequestUrl(),
                roleRequestBody.getCreateRoleRequestBody(MSP_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("Role Created"));

    }
    @Test
    public void createAdmin(){
        adminRequestBody = new AdminRequestBody();

        response = RestClientValidatableResponse.doPost(requestUrl.getAdminCreateRequestUrl(),
                adminRequestBody.getAdminCreateRequestBody(MSP_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions

    }
    @Test
    public void createCompany(){
        companyRequestBody = new CompanyRequestBody();

        response = RestClientValidatableResponse.doPost(requestUrl.getCompanyCreateRequestUrl(),
                companyRequestBody.getCompanyCreateRequestBody(MSP_ID,COMPANY_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions


    }
    @Test
    public void updateCompany(){
        companyRequestBody = new CompanyRequestBody();

        response = RestClientValidatableResponse.doPatch(requestUrl.getCompanyUpdateRequestUrl(),
                companyRequestBody.getCompanyUpdateRequestBody(MSP_ID,COMPANY_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions


    }
    @Test
    public void createStaff(){
        staffRequestBody = new StaffRequestBody();

        response = RestClientValidatableResponse.doPost(requestUrl.getStaffCreateRequestUrl(),
                staffRequestBody.getStaffCreateRequestBody(MSP_ID,STAFF_UNIQUE_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions




    }
    @Test
    public void updateStaff(){
        staffRequestBody = new StaffRequestBody();

        response = RestClientValidatableResponse.doPatch(requestUrl.getStaffUpdateRequestUrl(),
                staffRequestBody.getStaffUpdateRequestBody(MSP_ID,STAFF_UNIQUE_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions

    }
    @Test
    public void createUser(){
        userRequestBody = new UserRequestBody();

        response = RestClientValidatableResponse.doPost(requestUrl.getUserCreateRequestUrl(),
                userRequestBody.getUserCreateRequestBody(MSP_ID,COMPANY_ID,USER_UNIQUE_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions

    }
    @Test
    public void updateUser(){
        userRequestBody = new UserRequestBody();

        response = RestClientValidatableResponse.doPatch(requestUrl.getUserUpdateRequestUrl(),
                userRequestBody.getUserUpdateRequestBody(MSP_ID,COMPANY_ID,USER_UNIQUE_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions

    }
    @Test
    public void deleteUser(){
        userRequestBody = new UserRequestBody();

        response = RestClientValidatableResponse.doDelete(requestUrl.getUserDeleteRequestUrl(),
                userRequestBody.getUserDeleteRequestBody(MSP_ID,USER_UNIQUE_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
    }
    @Test
    public void deleteStaff(){
        staffRequestBody = new StaffRequestBody();

        response = RestClientValidatableResponse.doDelete(requestUrl.getStaffDeleteRequestUrl(),
                staffRequestBody.getStaffDeleteRequestBody(MSP_ID,STAFF_UNIQUE_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions

    }
    @Test
    public void deleteCompany(){
        companyRequestBody = new CompanyRequestBody();

        response = RestClientValidatableResponse.doDelete(requestUrl.getCompanyDeleteRequestUrl(),
                companyRequestBody.getCompanyDeleteRequestBody(MSP_ID,COMPANY_ID));

        //sout
        RestClientValidatableResponse.responseAsString(response);

        //assertions
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Delete MSP with DELETE operation")
    public void deleteMsp(){
        mspRequestBody= new MspRequestBody();

        response = RestClientValidatableResponse.doDelete(requestUrl.getMspDeleteRequestUrl(),
                mspRequestBody.getMspDeleteRequestBody(MSP_ID));

        RestClientValidatableResponse.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("SUCCESS"));
        response.assertThat().body("code", IsEqual.equalTo(201));
        response.assertThat().body("message", IsEqual.equalTo("MSP Deleted"));

    }

}

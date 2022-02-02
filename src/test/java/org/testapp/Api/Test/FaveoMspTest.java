package org.testapp.Api.Test;

import com.jayway.restassured.response.ValidatableResponse;
import io.qameta.allure.Description;
import org.testapp.Api.DataProvider.*;
import org.testapp.Api.PropertyManager.PropertyManager;
import org.testapp.Api.RestClient.RestClientValidatableResponse;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class FaveoMspTest {
    private String API_KEY = PropertyManager.getInstance().getApiKey();
    private String APP_URL = PropertyManager.getInstance().getUrl();
    private String MSP_ID = PropertyManager.getInstance().getMspId();
    private String ID = PropertyManager.getInstance().getId();
    private String COMPANY_ID = PropertyManager.getInstance().getCompanyId();
    private String STAFF_UNIQUE_ID = PropertyManager.getInstance().getStaffUniqueId();
    private String USER_UNIQUE_ID = PropertyManager.getInstance().getUserUniqueId();



    ValidatableResponse response;
    MspRequestBody mspRequestBody;
    AdminRequestBody adminRequestBody;
    CompanyRequestBody companyRequestBody;
    RoleRequestBody roleRequestBody;
    StaffRequestBody staffRequestBody;
    UserRequestBody userRequestBody;

    @Test
    public void testString(){
        mspRequestBody = new MspRequestBody();
        System.out.println(mspRequestBody.getMspCreateRequestBody(MSP_ID));
    }

    @Test
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

        response = RestClientValidatableResponse.doPost(APP_URL.concat("/pim/msps"),
                mspRequestBody.getMspCreateRequestBody(MSP_ID));
        RestClientValidatableResponse.responseAsString(response);

    }

    @Test
    public void updateMsp(){
        mspRequestBody= new MspRequestBody();
        response = RestClientValidatableResponse.doPost(APP_URL.concat("/pim/msps/"+ID),
                mspRequestBody.getMspUpdateBody(MSP_ID));
        RestClientValidatableResponse.responseAsString(response);
    }
    @Test
    public void holdMsp(){
        mspRequestBody= new MspRequestBody();
        response = RestClientValidatableResponse.doPost(APP_URL.concat("/pim/msps/"+ID+"/hold"),
                mspRequestBody.getMspHoldBody(MSP_ID));
        RestClientValidatableResponse.responseAsString(response);

    }
    @Test
    public void unholdMsp(){
        mspRequestBody= new MspRequestBody();

    }
    @Test
    public void createRole(){

    }
    @Test
    public void createAdmin(){

    }
    @Test
    public void createCompany(){

    }
    @Test
    public void updateCompany(){

    }
    @Test
    public void createStaff(){

    }
    @Test
    public void updateStaff(){

    }
    @Test
    public void createUser(){

    }
    @Test
    public void updateUser(){

    }
    @Test
    public void deleteUser(){

    }
    @Test
    public void deleteStaff(){

    }
    @Test
    public void deleteCompany(){

    }

    @Test
    public void deleteMsp(){
        response = RestClientValidatableResponse.doDelete(APP_URL.concat("delete/aa"),
                mspRequestBody.getMspDeleteRequestBody(MSP_ID));
    }

}

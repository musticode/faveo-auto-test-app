package org.testapp.Api.Test;

import com.jayway.restassured.response.ValidatableResponse;
import org.hamcrest.core.IsEqual;
import org.testapp.Api.PropertyManager.TenantPropertyManager;
import org.testapp.Api.RestClient.RestClientTenant;
import org.testng.annotations.Test;

public class TenantNewAccountTest {

    private String TENANT_URL = TenantPropertyManager.getInstance().getTenantUrl();

    ValidatableResponse response;


    @Test
    public void getTenantStatus(){
        response = RestClientTenant.doGet(TENANT_URL.concat("api/v1/tenant/status/test"));
        RestClientTenant.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo(200));
        response.assertThat().body("success", IsEqual.equalTo(true));
        response.assertThat().body("data.tenant_status", IsEqual.equalTo("Created"));
    }

    @Test
    public void registerTenant(){

    }

    @Test
    public void loginTenant(){

    }

    @Test

    public void passwordChangeTenant(){

    }




}

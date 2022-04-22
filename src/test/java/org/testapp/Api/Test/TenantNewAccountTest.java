package org.testapp.Api.Test;

import com.jayway.restassured.response.ValidatableResponse;
import io.qameta.allure.Description;
import org.hamcrest.core.IsEqual;
import org.testapp.Api.DataProvider.Tenant.LoginRequestBody;
import org.testapp.Api.DataProvider.Tenant.PasswordChangeRequestBody;
import org.testapp.Api.DataProvider.Tenant.RegisterRequestBody;
import org.testapp.Api.PropertyManager.TenantPropertyManager;
import org.testapp.Api.RestClient.RestClientTenant;
import org.testapp.Ui.Listener.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(TestListener.class)
public class TenantNewAccountTest {

    private String TENANT_URL = TenantPropertyManager.getInstance().getTenantUrl();
    private String tenantUserName = TenantPropertyManager.getInstance().getTenantUserName();
    private String tenantPassword = TenantPropertyManager.getInstance().getTenantPassword();
    private String tenantCompanyName = TenantPropertyManager.getInstance().getTenantSubDomain();
    private String tenantSubdomain = TenantPropertyManager.getInstance().getTenantSubDomain();
    private String tenantEmail = TenantPropertyManager.getInstance().getTenantEmail();
    private String tenantNewPassword = TenantPropertyManager.getInstance().getTenantNewPassword();


    ValidatableResponse response;

    LoginRequestBody loginRequestBody = new LoginRequestBody();
    RegisterRequestBody registerRequestBody = new RegisterRequestBody();
    PasswordChangeRequestBody passwordChangeRequestBody = new PasswordChangeRequestBody();

    @Test
    @Description("Get tenant status")
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
    @Description("register tenant with valid credentials")
    public void registerTenant(){
        response = RestClientTenant.doPost(TENANT_URL.concat("api/v1/tenant/status/test"),
                registerRequestBody
                .getTenantRegisterRequestBody(tenantUserName, tenantNewPassword, tenantEmail,tenantCompanyName, tenantSubdomain));

        RestClientTenant.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);

    }

    @Test
    @Description("Login tenant with valid credentials")
    public void loginTenant(){
        response = RestClientTenant.doPost(TENANT_URL.concat("api/v1/tenant/login"),
                loginRequestBody.getTenantLoginRequestBody(tenantEmail, tenantPassword));


        RestClientTenant.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("success"));
        response.assertThat().body("success", IsEqual.equalTo(true));

    }

    @Test
    @Description("Tenant password change")
    public void passwordChangeTenant(){
        response = RestClientTenant.doPost(TENANT_URL.concat("api/v1/tenant/password"),
                passwordChangeRequestBody.getTenantPasswordChangeRequestBody(tenantEmail, tenantPassword, tenantNewPassword));


        RestClientTenant.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);

    }




}

package org.testapp.Api.Test.RestTestClasses;

import com.jayway.restassured.response.ValidatableResponse;
import io.qameta.allure.Description;
import org.hamcrest.core.IsEqual;
import org.testapp.Api.DataProvider.DataGenerator.FakeDataGenerator;
import org.testapp.Api.DataProvider.Tenant.LoginRequestBody;
import org.testapp.Api.DataProvider.Tenant.PasswordChangeRequestBody;
import org.testapp.Api.DataProvider.Tenant.RegisterRequestBody;
import org.testapp.Api.PropertyManager.TenantSaasPropertyManager;
import org.testapp.Api.RestClient.RestClientTenant;
import org.testapp.Api.RestClient.abstraction.RestClient;
import org.testapp.Api.RestClient.abstraction.TenantSaasRestClient;
import org.testng.annotations.Test;

public class TenantSaasTest {
    RestClient tenantSaasTest = new TenantSaasRestClient();

    private String TENANT_URL = TenantSaasPropertyManager.getInstance().getTenantUrl();
    private String tenantUserName = TenantSaasPropertyManager.getInstance().getTenantUserName();
    private String tenantPassword = TenantSaasPropertyManager.getInstance().getTenantPassword();
    private String tenantCompanyName = TenantSaasPropertyManager.getInstance().getTenantSubDomain();
    private static String tenantSubdomain = TenantSaasPropertyManager.getInstance().getTenantSubDomain();
    private static String tenantEmail = TenantSaasPropertyManager.getInstance().getTenantEmail();
    private String tenantNewPassword = TenantSaasPropertyManager.getInstance().getTenantNewPassword();

    //fake data
    static FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();
    private static String fakeTenantSubdomain = fakeDataGenerator.fakeTenantSubdomain(tenantSubdomain);
    private static String fakeEmail = fakeDataGenerator.fakeTenantEmail(tenantEmail);



    @Test( priority = 0)
    public void test(){
        System.out.println("test data fake tenant subdomain:" + fakeTenantSubdomain);
        System.out.println("test fake email " + fakeEmail);
    }


    ValidatableResponse response;

    LoginRequestBody loginRequestBody = new LoginRequestBody();
    RegisterRequestBody registerRequestBody = new RegisterRequestBody();
    PasswordChangeRequestBody passwordChangeRequestBody = new PasswordChangeRequestBody();

    @Test (priority = 1)
    @Description("register tenant with valid credentials")
    public void registerTenant(){
        response = tenantSaasTest.doPost(TENANT_URL.concat("api/v1/tenant/register"),
                registerRequestBody
                        .getTenantRegisterRequestBody(tenantUserName, tenantPassword, fakeEmail,tenantCompanyName, fakeTenantSubdomain));

        RestClientTenant.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);

    }

    @Test (priority = 2)
    @Description("Get tenant status")
    public void getTenantStatus() throws InterruptedException {
        Thread.sleep(50000);
        response = tenantSaasTest.doGet(TENANT_URL.concat("api/v1/tenant/status/"+ fakeTenantSubdomain));
        RestClientTenant.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo(200));
        response.assertThat().body("success", IsEqual.equalTo(true));
        response.assertThat().body("data.tenant_status", IsEqual.equalTo("Created"));
    }

    @Test (priority = 3)
    @Description("Login tenant with valid credentials")
    public void loginTenant(){
        response = tenantSaasTest.doPost(TENANT_URL.concat("api/v1/tenant/login"),
                loginRequestBody.getTenantLoginRequestBody(fakeEmail, tenantPassword));


        RestClientTenant.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("success"));
        response.assertThat().body("success", IsEqual.equalTo(true));

    }

    @Test (priority = 4)
    @Description("Tenant password change")
    public void passwordChangeTenant(){
        response = tenantSaasTest.doPost(TENANT_URL.concat("api/v1/tenant/password"),
                passwordChangeRequestBody.getTenantPasswordChangeRequestBody(fakeEmail, tenantPassword, tenantNewPassword));


        RestClientTenant.responseAsString(response);

        //assertions
        response.assertThat().statusCode(200);
        response.assertThat().body("status", IsEqual.equalTo("success"));

    }

}

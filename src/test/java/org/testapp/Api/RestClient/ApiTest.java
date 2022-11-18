package org.testapp.Api.RestClient;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import org.testapp.Api.PropertyManager.PimApiPropertyManager;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.jayway.restassured.RestAssured.given;

public class ApiTest {
    private String API_KEY = PimApiPropertyManager.getInstance().getApiKey();
    private String APP_URL = PimApiPropertyManager.getInstance().getUrl();
    private static String MSP_ID = PimApiPropertyManager.getInstance().getMspId();
    private String ID = PimApiPropertyManager.getInstance().getId();
    private String COMPANY_ID = PimApiPropertyManager.getInstance().getCompanyId();
    private String STAFF_UNIQUE_ID = PimApiPropertyManager.getInstance().getStaffUniqueId();
    private String USER_UNIQUE_ID = PimApiPropertyManager.getInstance().getUserUniqueId();

    ValidatableResponse response;

    @Test(priority = 3)
    public void testApi1(){
        response = given()
                .contentType(ContentType.JSON)
                .get("https://reqres.in/api/users?page=2")
                .then();
        response.log().body().extract().asString();
        response.assertThat().statusCode(200);
    }

    static FakeValuesService faker = new FakeValuesService(new Locale("en-US"), new RandomService());
    String fakeCompanyId =  faker.numerify(MSP_ID+"####");
    static String fakeRegexCompanyId = faker.regexify(MSP_ID+"[a-z1-9]{5}");

    @Test(priority = 2)
    public void randomDataGeneratorTest(){
        System.out.println(MSP_ID);
        System.out.println(fakeCompanyId);
        System.out.println(fakeRegexCompanyId);
    }

    @Test(priority = 1)
    public void randomDataGeneratorTest2(){
        System.out.println(MSP_ID);
        System.out.println(fakeCompanyId);
        System.out.println(fakeRegexCompanyId);


    }




}

package org.testapp.Api.RestClient;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import org.testapp.Api.PropertyManager.PropertyManager;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.jayway.restassured.RestAssured.given;

public class ApiTest {
    private String API_KEY = PropertyManager.getInstance().getApiKey();
    private String APP_URL = PropertyManager.getInstance().getUrl();
    private static String MSP_ID = PropertyManager.getInstance().getMspId();
    private String ID = PropertyManager.getInstance().getId();
    private String COMPANY_ID = PropertyManager.getInstance().getCompanyId();
    private String STAFF_UNIQUE_ID = PropertyManager.getInstance().getStaffUniqueId();
    private String USER_UNIQUE_ID = PropertyManager.getInstance().getUserUniqueId();

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

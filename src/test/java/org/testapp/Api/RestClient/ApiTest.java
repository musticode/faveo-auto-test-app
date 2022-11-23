package org.testapp.Api.RestClient;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.testapp.Api.DataProvider.Pim.StaffRequestBody;
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


        //response id object

        JSONObject idObject = new JSONObject(response.log().body().toString());
        System.out.println("email from json object" + idObject.getString("email"));

    }

    @Test
    public void testReqresPost(){
        response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .post("https://reqres.in/api/users")
                .then();
        response.log().body().extract().asString();



        //response id object
        JSONObject idObject = new JSONObject(response.log().body().extract().asString());

        System.out.println("email from json object" + idObject.get("name"));
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

    //test data set
    StaffRequestBody staffRequestBody = new StaffRequestBody();
    @Test
    public void test1(){
        staffRequestBody.setStaffIdEndpoint("update staff2");

    }

    @Test
    public void test2(){
        System.out.println(staffRequestBody.getStaffIdEndpoint());
        System.out.println();
        System.out.println(staffRequestBody.getStaffUpdateRequestBody("update staff2","update staff2"));




    }

    @Test
    public void jsonObjectTest(){
        //https://www.javatpoint.com/how-to-get-value-from-json-object-in-java-example

        JSONObject obj = new JSONObject("{" +
                "Employee ID: 092789," +
                "Employee Name: Helen Mirren," +
                "Age: 27, " +
                "Designation: Assistant Manager," +
                "City: Florida," +
                "Salary: 67000.00, " +
                "Experience: 26 " +
                "}"
        );

        System.out.println(obj.get("Employee ID"));
        System.out.println(obj.get("Age"));


        System.out.println("Employee ID: "+obj.getInt("Employee ID"));
        System.out.println("Employee Name: "+obj.getString("Employee Name"));
        System.out.println("Age: "+obj.getInt("Age"));
        System.out.println("Designation: "+obj.getString("Designation"));
        System.out.println("City: "+obj.getString("City"));
        System.out.println("Salary: "+obj.getDouble("Salary"));
        System.out.println("Experience: "+obj.getInt("Experience") +" Months");

        System.out.println(obj.toString());
    }




}

package org.testapp.Api.RestClient;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class ApiTest {
    ValidatableResponse response;

    @Test
    public void testApi1(){
        response = given()
                .contentType(ContentType.JSON)
                .get("https://reqres.in/api/users?page=2")
                .then();
        response.log().body().extract().asString();
        response.assertThat().statusCode(200);
    }


}

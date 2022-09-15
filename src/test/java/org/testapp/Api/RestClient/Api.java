package org.testapp.Api.RestClient;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.testapp.Api.RestClient.abstraction.RestClient;
import org.testapp.Api.RestClient.abstraction.SubRestClient;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class Api {

    public RequestSpecification getRequestSpecification(){
        return given()
                //.header("Authorization",BEARER_TOKEN)
                .contentType(ContentType.JSON);
    }

    public ValidatableResponse getRequest(String path){
        return getRequestSpecification()
                .get(path)
                .then();
    }


    public ValidatableResponse postRequest(String path, String body){
        return getRequestSpecification()
                .body(body)
                .post(path)
                .then();
    }

    public String responseAsString(ValidatableResponse response){
        String responseToString = response.log().body().extract().asString();
        return responseToString;
    }

    public boolean isReturned200(ValidatableResponse response){
        if(response.extract().statusCode() == 200){
            System.out.println("Response status code: "+response.extract().statusCode());
            return true;
        }else{
            System.out.println("Response time: "+response.extract().time());
            return false;
        }
    }


    @Test
    public void test(){
        ValidatableResponse response4 = getRequest("https://staging.osticket.dmdemo.comodo.com/pim/msps");
        isReturned200(response4);
        responseAsString(response4);


    }

    @Test
    public void test2FaveoApi(){


    }

    @Test
    public void testReqres(){
        ValidatableResponse resp1 = getRequest("https://reqres.in/api/users?page=2");
        responseAsString(resp1);
    }

    @Test
    public void testRestClient(){
        ValidatableResponse resp = RestClientValidatableResponse.doGet("https://reqres.in/api/users?page=2");
        resp.toString();
    }
    ValidatableResponse response;
    @Test
    public void reqresTest2(){
        response = given()
                .contentType(ContentType.JSON)
                .get("https://reqres.in/api/users?page=2")
                .then();
        response.log().body().extract().asString();
        response.assertThat().statusCode(200);


    }
    @Test
    public void test1(){
        System.out.println("aaa");
    }

    @Test
    public void faveoApiGetTest(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Basic dGVzdGFjY291bnRtc3AzOmVUdk9oQW55UFpubm5kczIzUWk1bEJUOERRM2xnaXI4")
                .get("https://api.servicedeskv2.dmdemo.comodo.com/api/v1/tickets")
                .then();
        response.log().body().extract().asString();
        response.assertThat().statusCode(200);


    }

    @Test
    public void tesrtttt(){
        response = RestClientFaveoApi.doGet("https://api.servicedeskv2.dmdemo.comodo.com/api/v1/tickets");
        response.log().body().extract().asString();
        response.assertThat().statusCode(200);
    }

    @Test
    public void tesrtttt2Abstract(){
        RestClient rest = new SubRestClient();
        response = rest.doGet("https://api.servicedeskv2.dmdemo.comodo.com/api/v1/tickets");
        response.log().body().extract().asString();
        response.assertThat().statusCode(200);
    }

}

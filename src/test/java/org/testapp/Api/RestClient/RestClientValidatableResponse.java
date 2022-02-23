package org.testapp.Api.RestClient;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.testapp.Api.PropertyManager.PropertyManager;

import static com.jayway.restassured.RestAssured.given;

public class RestClientValidatableResponse {
    private static final String API_KEY = PropertyManager.getInstance().getApiKey();

    public static ValidatableResponse doGet(String url){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(API_KEY);
        return RestClientValidatableResponse.getResponse("GET",req,url);

    }
    public static ValidatableResponse doPost(String url,/*MspRequestBody body*/ String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("POST",req,url);

    }
    public static ValidatableResponse doPatch(String url,  String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PATCH",req,url);

    }
    public static ValidatableResponse doPut(String url,  String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PUT",req,url);

    }
    public static ValidatableResponse doDelete(String url,String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(API_KEY);

        req.body(body);
        return RestClientValidatableResponse.getResponse("DELETE",req,url);
    }


    public static RequestSpecification getRequestSpecification(String token) {
        RequestSpecification reqSpec;
        if (token != null) {
            reqSpec = given()
                    .header("Authorization", token)
                    .contentType(ContentType.JSON);
            return reqSpec;
        } else {
            return given();
        }
    }
    public static ValidatableResponse execute(String httpMethod, RequestSpecification reqSpec, String path){
        ValidatableResponse response = null;
        switch(httpMethod){
            case "GET":
                response = reqSpec.get(path).then();
                break;
            case "POST":
                response = reqSpec.post(path).then();
                break;
            case "PATCH":
                response = reqSpec.patch(path).then();
                break;
            case "PUT":
                response = reqSpec.put(path).then();
                break;
            case "DELETE":
                response = reqSpec.delete(path).then();
                break;
            default:
                System.out.println("---");
                break;
        }
        return response;
    }

    public static ValidatableResponse getResponse(String httpMethod, RequestSpecification reqSpec, String path){
        return execute(httpMethod, reqSpec, path);
    }

    public static void responseAsString(ValidatableResponse response){
        System.out.println("===========Response============");
        response.log().body().extract().asString();
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


/*
    @Test
    public void testGet(){
        ValidatableResponse response = doGet("https://staging.osticket.dmdemo.comodo.com/pim/msps");
        responseAsString(response);
//        getResponseCode(response);
        isReturned200(response);
    }

    @Test
    public void testDelete(){
//        ValidatableResponse response2 = doDelete("https://reqres.in/api/users/2");
//        response2.log().body().extract().toString();
    }

    @Test
    public void testReqres(){
        ValidatableResponse response3 = doGet("https://reqres.in/api/users/2");
        response3.log().body().extract().asString();
    }
    @Test
    public void testmsp(){
        MspRequestBody requestBody = new MspRequestBody();

        ValidatableResponse response = doPatch("https://sprint9stag1msp.osticket.dmdemo.comodo.com/pim/msps/must4", requestBody.getMspUpdateBody("must4"));
        response.log().body().extract().asString();


    }
*/







}

package org.testapp.Api.RestClient.abstraction;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.testapp.Api.RestClient.RestClientValidatableResponse;

import static com.jayway.restassured.RestAssured.given;

public abstract class RestClient {

    public abstract ValidatableResponse doGet(String url);
    public abstract ValidatableResponse doPost(String url, String body);
    public abstract ValidatableResponse doPatch(String url,  String body);
    public abstract ValidatableResponse doPut(String url,  String body);
    public abstract ValidatableResponse doDelete(String url,String body);


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
    public ValidatableResponse execute(String httpMethod, RequestSpecification reqSpec, String path){
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

    public ValidatableResponse getResponse(String httpMethod, RequestSpecification reqSpec, String path){
        return execute(httpMethod, reqSpec, path);
    }

    public void responseAsString(ValidatableResponse response){
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
}

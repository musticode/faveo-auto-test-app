package org.testapp.Api.RestClient.abstraction;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.testapp.Api.PropertyManager.PimApiPropertyManager;
import org.testapp.Api.RestClient.RestClientValidatableResponse;

public class PimApiRestClient extends RestClient{
    private static final String API_KEY = PimApiPropertyManager.getInstance().getApiKey();


    @Override
    public ValidatableResponse doGet(String url) {
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(API_KEY);
        return RestClientValidatableResponse.getResponse("GET",req,url);

        //return null;
    }

    @Override
    public ValidatableResponse doPost(String url, String body) {

        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("POST",req,url);
    }

    @Override
    public ValidatableResponse doPatch(String url, String body) {
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PATCH",req,url);
    }

    @Override
    public ValidatableResponse doPut(String url, String body) {
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PUT",req,url);
    }

    @Override
    public ValidatableResponse doDelete(String url, String body) {
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(API_KEY);

        req.body(body);
        return RestClientValidatableResponse.getResponse("DELETE",req,url);
    }
}

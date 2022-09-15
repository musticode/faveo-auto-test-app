package org.testapp.Api.RestClient.abstraction;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.testapp.Api.PropertyManager.FaveoApiPropertyManager;
import org.testapp.Api.RestClient.RestClientValidatableResponse;

public class SubRestClient extends RestClient{
    private static final String FAVEO_AUTH_KEY = FaveoApiPropertyManager.getInstance().getAuthorization();

    @Override
    public ValidatableResponse doGet(String url) {
        RequestSpecification req = RestClient.getRequestSpecification(FAVEO_AUTH_KEY);
        return getResponse("GET",req,url);

    }

    @Override
    public ValidatableResponse doPost(String url, String body) {
        RequestSpecification req = RestClient.getRequestSpecification(FAVEO_AUTH_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("POST",req,url);

    }

    @Override
    public ValidatableResponse doPatch(String url, String body) {
        RequestSpecification req = RestClient.getRequestSpecification(FAVEO_AUTH_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PATCH",req,url);
    }

    @Override
    public ValidatableResponse doPut(String url, String body) {
        RequestSpecification req = RestClient.getRequestSpecification(FAVEO_AUTH_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PUT",req,url);
    }

    @Override
    public ValidatableResponse doDelete(String url, String body) {
        RequestSpecification req = RestClient.getRequestSpecification(FAVEO_AUTH_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("DELETE",req,url);
    }
}

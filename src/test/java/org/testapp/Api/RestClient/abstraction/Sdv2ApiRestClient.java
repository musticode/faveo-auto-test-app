package org.testapp.Api.RestClient.abstraction;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.testapp.Api.PropertyManager.Sdv2ApiPropertyManager;

public class Sdv2ApiRestClient extends RestClient{
    private static final String FAVEO_AUTH_KEY = Sdv2ApiPropertyManager.getInstance().getAuthorization();

    @Override
    public ValidatableResponse doGet(String url) {
        RequestSpecification req = RestClient.getRequestSpecification(FAVEO_AUTH_KEY);
        return getResponse("GET",req,url);

    }

    @Override
    public ValidatableResponse doPost(String url, String body) {
        RequestSpecification req = RestClient.getRequestSpecification(FAVEO_AUTH_KEY);
        req.body(body);
        return getResponse("POST",req,url);

    }

    @Override
    public ValidatableResponse doPatch(String url, String body) {
        RequestSpecification req = RestClient.getRequestSpecification(FAVEO_AUTH_KEY);
        req.body(body);
        return getResponse("PATCH",req,url);
    }

    @Override
    public ValidatableResponse doPut(String url, String body) {
        RequestSpecification req = RestClient.getRequestSpecification(FAVEO_AUTH_KEY);
        req.body(body);
        return getResponse("PUT",req,url);
    }

    @Override
    public ValidatableResponse doDelete(String url, String body) {
        RequestSpecification req = RestClient.getRequestSpecification(FAVEO_AUTH_KEY);
        req.body(body);
        return getResponse("DELETE",req,url);
    }
}

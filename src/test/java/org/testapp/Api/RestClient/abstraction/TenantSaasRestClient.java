package org.testapp.Api.RestClient.abstraction;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.testapp.Api.PropertyManager.TenantSaasPropertyManager;
import org.testapp.Api.RestClient.RestClientValidatableResponse;

public class TenantSaasRestClient extends RestClient {
    private static final String TENANT_API_KEY = TenantSaasPropertyManager.getInstance().getTenantApiKey();


    @Override
    public ValidatableResponse doGet(String url) {
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        //req.body(body);
        return RestClientValidatableResponse.getResponse("GET",req,url);
    }

    @Override
    public ValidatableResponse doPost(String url, String body) {
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("POST",req,url);
    }

    @Override
    public ValidatableResponse doPatch(String url, String body) {
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PATCH",req,url);
    }

    @Override
    public ValidatableResponse doPut(String url, String body) {
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PUT",req,url);
    }

    @Override
    public ValidatableResponse doDelete(String url, String body) {
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("DELETE",req,url);
    }
}

package org.testapp.Api.RestClient;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.testapp.Api.PropertyManager.TenantPropertyManager;

public class RestClientTenant extends RestClientValidatableResponse{
    private static final String TENANT_API_KEY = TenantPropertyManager.getInstance().getTenantApiKey();


//    @Override
    public static ValidatableResponse doGet(String url){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        return RestClientValidatableResponse.getResponse("GET",req,url);

    }
//    @Override
    public static ValidatableResponse doPost(String url,/*MspRequestBody body*/ String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("POST",req,url);

    }
//    @Override
    public static ValidatableResponse doPatch(String url,  String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PATCH",req,url);

    }
//    @Override
    public static ValidatableResponse doPut(String url,  String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PUT",req,url);

    }
//    @Override
    public static ValidatableResponse doDelete(String url,String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);

        req.body(body);
        return RestClientValidatableResponse.getResponse("DELETE",req,url);
    }


}

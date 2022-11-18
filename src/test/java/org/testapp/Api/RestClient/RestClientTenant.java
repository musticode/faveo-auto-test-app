package org.testapp.Api.RestClient;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.testapp.Api.PropertyManager.TenantSaasPropertyManager;

public class RestClientTenant extends RestClientValidatableResponse{
    private static final String TENANT_API_KEY = TenantSaasPropertyManager.getInstance().getTenantApiKey();

    public static ValidatableResponse doGetWithBody(String url, String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("GET",req,url);
    }


    public static ValidatableResponse doGet(String url /*,String body*/){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        //req.body(body);
        return RestClientValidatableResponse.getResponse("GET",req,url);

    }

    public static ValidatableResponse doPost(String url,/*MspRequestBody body*/ String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("POST",req,url);

    }

    public static ValidatableResponse doPatch(String url,  String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PATCH",req,url);

    }

    public static ValidatableResponse doPut(String url,  String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);
        req.body(body);
        return RestClientValidatableResponse.getResponse("PUT",req,url);

    }

    public static ValidatableResponse doDelete(String url,String body){
        RequestSpecification req = RestClientValidatableResponse.getRequestSpecification(TENANT_API_KEY);

        req.body(body);
        return RestClientValidatableResponse.getResponse("DELETE",req,url);
    }


}

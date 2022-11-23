package org.testapp.Api.DataProvider.Tenant;

import org.json.JSONObject;

public class LoginRequestBody {
    public String getTenantLoginRequestBody(String tenantEmail, String tenantPassword ){
        JSONObject tenantLoginRequestObject = new JSONObject();

        tenantLoginRequestObject.put("email", tenantEmail);
        tenantLoginRequestObject.put("password", tenantPassword);

        return tenantLoginRequestObject.toString();
    }



}

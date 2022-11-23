package org.testapp.Api.DataProvider.Tenant;

import org.json.JSONObject;

public class RegisterRequestBody {

    public String getTenantRegisterRequestBody(String tenantUserName, String tenantPassword, String tenantEmail, String tenantCompanyName, String tenantSubdomain ){
        JSONObject tenantRegisterRequestObject = new JSONObject();
        tenantRegisterRequestObject.put("user_name", tenantUserName);
        tenantRegisterRequestObject.put("password", tenantPassword);
        tenantRegisterRequestObject.put("password_confirmation", tenantPassword);
        tenantRegisterRequestObject.put("email", tenantEmail);
        tenantRegisterRequestObject.put("company_name", tenantCompanyName);
        tenantRegisterRequestObject.put("subdomain", tenantSubdomain);
        return tenantRegisterRequestObject.toString();
    }


}

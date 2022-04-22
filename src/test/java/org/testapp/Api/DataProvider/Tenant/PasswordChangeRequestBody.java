package org.testapp.Api.DataProvider.Tenant;

import org.json.JSONObject;

public class PasswordChangeRequestBody {
    public String getTenantPasswordChangeRequestBody(String tenantEmail, String tenantPassword, String tenantNewPassword ){
        JSONObject tenantPasswordChangeRequestObject = new JSONObject();
        tenantPasswordChangeRequestObject.put("email", tenantEmail);
        tenantPasswordChangeRequestObject.put("current_password", tenantPassword);
        tenantPasswordChangeRequestObject.put("password", tenantPassword);
        tenantPasswordChangeRequestObject.put("password_confirmation", tenantNewPassword);

        return tenantPasswordChangeRequestObject.toString();
    }

}

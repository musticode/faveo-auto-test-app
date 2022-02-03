package org.testapp.Api.DataProvider;

import org.testapp.Api.PropertyManager.PropertyManager;

public class RoleRequestBody {
    private String API_KEY = PropertyManager.getInstance().getApiKey();

    public String getCreateRoleRequestBody(){
        return "body";

    }
}

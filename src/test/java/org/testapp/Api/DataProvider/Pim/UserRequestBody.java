package org.testapp.Api.DataProvider.Pim;

import org.json.JSONObject;
import org.testapp.Api.PropertyManager.PropertyManager;

public class UserRequestBody {
    private String API_KEY = PropertyManager.getInstance().getApiKey();

    public String getUserCreateRequestBody(String mspId, String companyId, String userUniqueId){
        JSONObject paramsObject = new JSONObject();
        paramsObject.put("companyId", companyId);

        paramsObject.put("name","onur göker");
        paramsObject.put("email","test1@user.com");
        paramsObject.put("userType","c1-azure-user");

        paramsObject.put("userStatus","user-active");
        paramsObject.put("id",userUniqueId);
//


        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","userCreated");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);
        requestBody.put("targetNameSpace","ServiceDesk");
        requestBody.put("senderNameSpace","RMM");


        requestBody.put("targetApiKey",API_KEY);

        return requestBody.toString();
    }

    public String getUserUpdateRequestBody(String mspId, String companyId, String userUniqueId){
        JSONObject paramsObject = new JSONObject();
        paramsObject.put("companyId", companyId);

        paramsObject.put("name","onur göker");
        paramsObject.put("email","test16@user.com");
        paramsObject.put("userType","c1-azure-user");

        paramsObject.put("userStatus","user-active");
        paramsObject.put("id",userUniqueId);
//


        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","userUpdated");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);
        requestBody.put("targetNameSpace","ServiceDesk");
        requestBody.put("senderNameSpace","RMM");


        requestBody.put("targetApiKey",API_KEY);
        return requestBody.toString();
    }
    public String getUserDeleteRequestBody(String mspId, String userUniqueId){
        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id",userUniqueId);
//


        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","userDeleted");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);
        requestBody.put("targetNameSpace","ServiceDesk");
        requestBody.put("senderNameSpace","RMM");
        requestBody.put("serviceName","userOp");


        requestBody.put("targetApiKey",API_KEY);
        return requestBody.toString();
    }

}

package org.testapp.Api.DataProvider.Pim;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testapp.Api.PropertyManager.PimApiPropertyManager;

public class StaffRequestBody {
    private String API_KEY = PimApiPropertyManager.getInstance().getApiKey();
    private String staffIdEndpoint;

    public StaffRequestBody(){

    }
    public StaffRequestBody(String staffIdEndpoint){
        this.staffIdEndpoint = staffIdEndpoint;
    }

    public String getStaffIdEndpoint(){
        return  staffIdEndpoint;
    }

    public void setStaffIdEndpoint(String staffIdEndpoint) {
        this.staffIdEndpoint = staffIdEndpoint;
    }


    public String getStaffCreateRequestBody(String mspId, String staffUniqueId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-msp-admin");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id", staffUniqueId);
        paramsObject.put("mspId",mspId);
        paramsObject.put("name","Admin Copy");
        paramsObject.put("types",typesArr);
        paramsObject.put("email","admincopy2_edit1@yopmail.com");
        paramsObject.put("roleId","4");
        paramsObject.put("timeZone","GMT+03:00");





        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","adminCreated");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);
        requestBody.put("senderNameSpace","onursd");
        requestBody.put("targetApiKey",API_KEY);
        return requestBody.toString();
    }

    public String getStaffUpdateRequestBody(String mspId, String staffUniqueId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-msp-admin");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id", staffUniqueId);
        paramsObject.put("mspId",mspId);
        paramsObject.put("name","Sample Name");
        paramsObject.put("types",typesArr);
        paramsObject.put("email","staff@yopmail.com");
        paramsObject.put("roleId","5");
        paramsObject.put("message","Test Message");
        paramsObject.put("portal_id","portal_id");
        paramsObject.put("timeZone","GMT+03:00");


        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","adminUpdated");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);
        requestBody.put("senderNameSpace","onursd");
        requestBody.put("targetApiKey",API_KEY);
        return requestBody.toString();
    }

    public String getStaffDeleteRequestBody(String mspId, String staffUniqueId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-msp-agent");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id", staffUniqueId);

        paramsObject.put("name","Sample Name");
        paramsObject.put("types",typesArr);
        paramsObject.put("email","admin@email.com");
//


        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","adminDeleted");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);
        requestBody.put("eventDispatcherNameSpace","onursd");


        requestBody.put("targetApiKey",API_KEY);
        return requestBody.toString();
    }

}

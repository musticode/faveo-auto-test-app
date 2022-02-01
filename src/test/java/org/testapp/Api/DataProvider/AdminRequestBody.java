package org.testapp.Api.DataProvider;

import org.json.JSONArray;
import org.json.JSONObject;

public class AdminRequestBody {
    private String API_KEY = PropertyManager.getInstance().getApiKey();

    public String getAdminCreateRequestBody(String mspId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-msp-agent");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id","Test");
        paramsObject.put("mspId",mspId);
        paramsObject.put("name","Beyza İnce");
        paramsObject.put("camLogin", "null");
        paramsObject.put("types",typesArr);
        paramsObject.put("email","beyza.ince.zahirfaveaao@yopmail.com");

        paramsObject.put("subdomain","staging");
        paramsObject.put("acronisPassword","VNQ1EB8aAxdxf4y");
        paramsObject.put("timeZone","GMT+03:00");
        paramsObject.put("roleId",5);
        paramsObject.put("lang","en");

        JSONObject params2Object=new JSONObject();
        paramsObject.put("senderModuleId","ComodoOnePortal");
        paramsObject.put("mspId",mspId);




        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","adminCreated");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);
        requestBody.put("",params2Object);
        requestBody.put("requestId","6afcc4e0-7e95-11ec-b6c2-5bb1dd946257");
        requestBody.put("senderNameSpace","ComodoOnePortal");
        requestBody.put("additionalData","");
        requestBody.put("eventDispatcherNameSpace","ComodoOnePortal");
        requestBody.put("targetApiKey",API_KEY);


        return requestBody.toString();
    }

}

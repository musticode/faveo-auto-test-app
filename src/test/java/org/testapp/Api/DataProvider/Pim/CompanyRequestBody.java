package org.testapp.Api.DataProvider.Pim;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testapp.Api.PropertyManager.PropertyManager;

public class CompanyRequestBody {
    private String API_KEY = PropertyManager.getInstance().getApiKey();


    public String getCompanyCreateRequestBody(String mspId, String companyId){

        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-company");
        JSONArray typesArr2 = new JSONArray();
        typesArr.put("5673f8edd07ab94e05a8d9a2");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id", companyId);
        paramsObject.put("mspId",mspId);
        paramsObject.put("name","one-two");
        paramsObject.put("types",typesArr);
        paramsObject.put("contactEmail","test@email.com");
        paramsObject.put("authenticatedAdminIds",typesArr2);




        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","companyCreated");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);


        requestBody.put("eventDispatcherNameSpace","ComodoOnePortal");
        requestBody.put("targetApiKey",API_KEY);

        return  requestBody.toString();
    }


    public String getCompanyUpdateRequestBody(String mspId, String companyId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-company");
        JSONArray typesArr2 = new JSONArray();
        typesArr.put("5673f8edd07ab94e05a8d9a2");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id", companyId);
        paramsObject.put("mspId",mspId);
        paramsObject.put("name","one-two-three");
        paramsObject.put("types",typesArr);
        paramsObject.put("contactEmail","test1@email.com");
        paramsObject.put("authenticatedAdminIds",typesArr2);

        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","companyUpdated");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);
        requestBody.put("eventDispatcherNameSpace","ComodoOnePortal");
        requestBody.put("targetApiKey",API_KEY);
        return requestBody.toString();
    }

    public String getCompanyDeleteRequestBody(String mspId, String companyId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-company");
        JSONArray typesArr2 = new JSONArray();
        typesArr.put("5673f8edd07ab94e05a8d9a2");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id", companyId);
        paramsObject.put("mspId",mspId);
        paramsObject.put("name","one-two");
        paramsObject.put("types",typesArr);
        paramsObject.put("contactEmail","test@email.com");
        paramsObject.put("authenticatedAdminIds",typesArr2);




        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","companyDeleted");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);
        requestBody.put("eventDispatcherNameSpace","ComodoOnePortal");
        requestBody.put("targetApiKey",API_KEY);
        return requestBody.toString();
    }



}

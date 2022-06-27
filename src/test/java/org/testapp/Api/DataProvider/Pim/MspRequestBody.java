package org.testapp.Api.DataProvider.Pim;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testapp.Api.PropertyManager.PropertyManager;
import org.testng.annotations.Test;

public class MspRequestBody {
    private String API_KEY = PropertyManager.getInstance().getApiKey();

    public String getMspCreateRequestBody(String mspId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-msp");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id",mspId);
        paramsObject.put("name","Company Name");
        paramsObject.put("types",typesArr);
        paramsObject.put("contactEmail","company@email.com");
        paramsObject.put("chapterId","mspId");
        paramsObject.put("subdomain",mspId);


        JSONObject requestBody = new JSONObject();
        requestBody.put("requestType","event");
        requestBody.put("eventName","mspCreated");
        requestBody.put("mspId",mspId);
        requestBody.put("params",paramsObject);
        requestBody.put("eventDispatcherNameSpace","ComodoOnePortal");
        requestBody.put("targetApiKey",API_KEY);

        return requestBody.toString();
    }

    public String getMspUpdateBody(String mspId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-msp");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id",mspId);
        paramsObject.put("name","test_update_name");
        paramsObject.put("subdomain",mspId);
        paramsObject.put("types",typesArr);
        paramsObject.put("contactEmail","mail@test.com");
        paramsObject.put("chapterId","mspId");
        paramsObject.put("timeZone", "GMT+03:00");

        JSONObject mspUpdateRequestBody = new JSONObject();
        mspUpdateRequestBody.put("eventDispatcherNameSpace","ComodoOnePortal");
        mspUpdateRequestBody.put("targetApiKey",API_KEY);
        mspUpdateRequestBody.put("mspId",mspId);
        mspUpdateRequestBody.put("requestType", "event");
        mspUpdateRequestBody.put("eventName", "mspUpdated");
        mspUpdateRequestBody.put("params",paramsObject);

        return mspUpdateRequestBody.toString();
    }

    public String getMspDeleteRequestBody(String mspId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-msp");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id",mspId);
        paramsObject.put("name","Name Surname");
        paramsObject.put("subdomain","MSPsubdomain");
        paramsObject.put("types",typesArr);
        paramsObject.put("contactEmail","mail@test.com");
        paramsObject.put("chapterId","mspID");

        JSONObject mspDeleteRequestBody = new JSONObject();
        mspDeleteRequestBody.put("eventDispatcherNameSpace","ComodoOnePortal");
        mspDeleteRequestBody.put("targetApiKey",API_KEY);
        mspDeleteRequestBody.put("mspId",mspId);
        mspDeleteRequestBody.put("requestType", "event");
        mspDeleteRequestBody.put("eventName", "mspDeleted");
        mspDeleteRequestBody.put("params",paramsObject);

        return  mspDeleteRequestBody.toString();

    }
    public String getMspHoldBody(String mspId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-msp");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id",mspId);
        paramsObject.put("name","Name Surname");
        paramsObject.put("subdomain","subdomain");
        paramsObject.put("types",typesArr);
        paramsObject.put("contactEmail","mail@test.com");
        paramsObject.put("chapterId","mspId");
        paramsObject.put("timeZone", "GMT+03:00");

        JSONObject mspHoldRequestBody = new JSONObject();
        mspHoldRequestBody.put("eventDispatcherNameSpace","ComodoOnePortal");
        mspHoldRequestBody.put("targetApiKey",API_KEY);
        mspHoldRequestBody.put("mspId",mspId);
        mspHoldRequestBody.put("requestType", "event");
        mspHoldRequestBody.put("eventName", "mspUpdated");
        mspHoldRequestBody.put("params",paramsObject);

        return  mspHoldRequestBody.toString();
    }
    public String getMspUnholdRequestBody(String mspId){
        JSONArray typesArr = new JSONArray();
        typesArr.put("c1-msp");

        JSONObject paramsObject = new JSONObject();
        paramsObject.put("id",mspId);
        paramsObject.put("name","Name Surname");
        paramsObject.put("subdomain","subdomain");
        paramsObject.put("types",typesArr);
        paramsObject.put("contactEmail","mail@test.com");
        paramsObject.put("chapterId","mspId");
        paramsObject.put("timeZone", "GMT+03:00");

        JSONObject mspUnholdRequestBody = new JSONObject();
        mspUnholdRequestBody.put("eventDispatcherNameSpace","ComodoOnePortal");
        mspUnholdRequestBody.put("targetApiKey",API_KEY);
        mspUnholdRequestBody.put("mspId",mspId);
        mspUnholdRequestBody.put("requestType", "event");
        mspUnholdRequestBody.put("eventName", "mspUpdated");
        mspUnholdRequestBody.put("params",paramsObject);

        return  mspUnholdRequestBody.toString();
    }



    @Test
    public void gson(){
        String mspId = "mustafa";

        String body =  "{\n" +
                "     \"eventDispatcherNameSpace\": \"ComodoOnePortal\",\n" +
                "     \"targetApiKey\": \"{{apiKey}}\",\n" +
                "     \"mspId\": \"{{mspId}}\",\n" +
                "     \"requestType\": \"event\",\n" +
                "     \"eventName\": \"mspUpdated\",\n" +
                "     \"params\": {\n" +
                "          \"id\": \"+{{mspId}}\",\n" +
                "          \"name\": \"Name Surname\",\n" +
                "          \"subdomain\": \"subdomain\",\n" +
                "          \"types\": [\"c1-msp\"],\n" +
                "          \"contactEmail\": \"mail@test.com\",\n" +
                "          \"chapterId\": \"mspId\",\n" +
                "          \"timeZone\":\"GMT+03:00\"\n" +
                "     }\n" +
                "}";



        System.out.println(body);



    }



    @Test
    public void mspId(){
//        System.out.println(getMspCreateRequestBody("test"));
        System.out.println(getMspCreateRequestBody("must111"));
    }

    @Test(dataProvider ="msp-request-data", dataProviderClass = TestDataProvider.class)
    public void testDataProvider(String requestData){
        System.out.println(getMspUpdateBody(requestData));
    }







}

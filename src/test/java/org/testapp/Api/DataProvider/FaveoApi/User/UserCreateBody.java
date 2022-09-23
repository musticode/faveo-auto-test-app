package org.testapp.Api.DataProvider.FaveoApi.User;

import org.json.JSONObject;

public class UserCreateBody {
    public String getUserCreatebody(String userProviderId, String userEmail){
        JSONObject dataObject = new JSONObject();

        dataObject.put("type", "users");


        JSONObject attributesObject = new JSONObject();



        return "{\n" +
                "  \"data\": {\n" +
                "    \"type\": \"users\",\n" +
                "    \"attributes\": {\n" +
                "                \"provider_id\" : \""+userProviderId+"\",\n" +
                "                \"email\" : \""+userEmail+"\",\n" +
                "                \"user_name\" : \"user@yopmail.com\",\n" +
                "                \"last_name\" : \"test_last_name\",\n" +
                "                \"first_name\" : \"test_first_name\",\n" +
                "                \"role\" : \"user\",\n" +
                "                \"company\" : \"1\",\n" +
                "                \"is_active\" : true,\n" +
                "                \"ext\" : \"\",\n" +
                "                \"country_code\" : 91,\n" +
                "                \"phone_number\" : \"\",\n" +
                "                \"mobile_number\" : \"\",\n" +
                "                \"internal_note\" : \"\",\n" +
                "                \"password\" : \"!!TEst123\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }
}

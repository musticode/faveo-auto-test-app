package org.testapp.Api.DataProvider.FaveoApi.Ticket;

import org.json.JSONObject;

public class CreateTicketRequestBody {
//    JSONObject ticket_thread = new JSONObject();
//    JSONObject attributes = new JSONObject();
//    JSONObject ticket_thread = new JSONObject();
//    JSONObject ticket_thread = new JSONObject();
//    JSONObject ticket_thread = new JSONObject();
//    JSONObject ticket_thread = new JSONObject();
//    JSONObject ticket_thread = new JSONObject();
//    JSONObject ticket_thread = new JSONObject();
//    JSONObject ticket_thread = new JSONObject();

    public String getTicketCreateRequestBody(){
        return "{\n" +
                "  \"data\": {\n" +
                "    \"type\": \"tickets\",\n" +
                "    \"attributes\": {\n" +
                "        \"duedate\" : \"2022-12-10 11:11:11\",\n" +
                "        \"ticket_thread\" : {\n" +
                "            \"subject\" : \"test_subject_a\",\n" +
                "            \"detail\" : \"test_detail_a\"\n" +
                "        }        \n" +
                "    },\n" +
                "    \"relationships\": {\n" +
                "\t\t\t\"slaplan\": {\n" +
                "\t\t\t\t\"data\": {\n" +
                "\t\t\t\t\t\"type\": \"slaplans\",\n" +
                "\t\t\t\t\t\"id\": \"1\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "            \"user\": {\n" +
                "\t\t\t\t\"data\": {\n" +
                "\t\t\t\t\t\"type\": \"users\",\n" +
                "\t\t\t\t\t\"id\": \"1\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "            \"staff\": {\n" +
                "\t\t\t\t\"data\": {\n" +
                "\t\t\t\t\t\"type\": \"users\",\n" +
                "\t\t\t\t\t\"id\": \"1\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "            \"helptopic\": {\n" +
                "\t\t\t\t\"data\": {\n" +
                "\t\t\t\t\t\"type\": \"helptopics\",\n" +
                "\t\t\t\t\t\"id\": \"3\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "            \"ticketpriority\": {\n" +
                "\t\t\t\t\"data\": {\n" +
                "\t\t\t\t\t\"type\": \"ticketpriorities\",\n" +
                "\t\t\t\t\t\"id\": \"4\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "            \"department\": {\n" +
                "\t\t\t\t\"data\": {\n" +
                "\t\t\t\t\t\"type\": \"departments\",\n" +
                "\t\t\t\t\t\"id\": \"1\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "  }\n" +
                "}";

    }


}

package org.testapp.Api.DataProvider.FaveoApi.Ticket;

public class UpdateTicketRequestBody {
    public String getUpdateTicketRequestBody(String ticketId){
        return "{\n" +
                "    \"data\": {\n" +
                "        \"id\": \""+ ticketId +"\",\n" +
                "        \"type\": \"tickets\",\n" +
                "        \"attributes\": {\n" +
                "            \"duedate\": \"2022-12-10 11:11:13\",\n" +
                "            \"ticket_thread\": {\n" +
                "                \"subject\": \"test_subject_update_a z\",\n" +
                "                \"detail\": \"test_detail_update z\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"relationships\": {\n" +
                "            \"slaplan\": {\n" +
                "                \"data\": {\n" +
                "                    \"type\": \"slaplans\",\n" +
                "                    \"id\": \"2\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"user\": {\n" +
                "                \"data\": {\n" +
                "                    \"type\": \"users\",\n" +
                "                    \"id\": \"1\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"helptopic\": {\n" +
                "                \"data\": {\n" +
                "                    \"type\": \"helptopics\",\n" +
                "                    \"id\": \"3\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"ticketpriority\": {\n" +
                "                \"data\": {\n" +
                "                    \"type\": \"ticketpriorities\",\n" +
                "                    \"id\": \"4\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"department\": {\n" +
                "                \"data\": {\n" +
                "                    \"type\": \"departments\",\n" +
                "                    \"id\": \"1\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"ticketstatus\": {\n" +
                "                \"data\": {\n" +
                "                    \"type\": \"ticketstatuses\",\n" +
                "                    \"id\": \"4\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

}

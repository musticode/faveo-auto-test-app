package org.testapp.Api.Test.RestTestClasses;

import com.jayway.restassured.response.ValidatableResponse;
import org.testapp.Api.PropertyManager.Sdv2ApiPropertyManager;
import org.testapp.Api.RestClient.abstraction.Sdv2ApiRestClient;
import org.testapp.Api.RestClient.abstraction.RestClient;
import org.testng.annotations.Test;

public class Sdv2ApiTest {

    String FAVEO_API_MAIN_URL = Sdv2ApiPropertyManager.getInstance().getFaveoApiUrl();


    ValidatableResponse response;
    RestClient sdv2ApiRestClient = new Sdv2ApiRestClient();

    @Test
    public void getAllMspTickets(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("tickets"));
        sdv2ApiRestClient.responseAsString(response);
//        response.log().body().extract().asString();
    }

    @Test
    public void  getOneTicketTest(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("tickets?filter[id][]=1")); //&filter[ticket_number]=AAAA-0000-0000
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void  createTicketTest(){
        String createTicketBody ="";
        response = sdv2ApiRestClient.doPost(FAVEO_API_MAIN_URL.concat("tickets"), createTicketBody);
        sdv2ApiRestClient.responseAsString(response);
    }

}

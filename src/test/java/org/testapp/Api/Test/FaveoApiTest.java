package org.testapp.Api.Test;

import com.jayway.restassured.response.ValidatableResponse;
import org.testapp.Api.PropertyManager.Sdv2ApiPropertyManager;
import org.testapp.Api.RestClient.abstraction.RestClient;
import org.testapp.Api.RestClient.abstraction.Sdv2ApiRestClient;
import org.testng.annotations.Test;

public class FaveoApiTest {

    String FAVEO_API_MAIN_URL = Sdv2ApiPropertyManager.getInstance().getFaveoApiUrl();


    ValidatableResponse response;
    RestClient faveoApiRestClient = new Sdv2ApiRestClient();

    @Test
    public void getAllMspTickets(){
        response = faveoApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("tickets"));
        faveoApiRestClient.responseAsString(response);
//        response.log().body().extract().asString();
    }

    @Test
    public void  getOneTicketTest(){
        response = faveoApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("tickets?filter[id][]=1")); //&filter[ticket_number]=AAAA-0000-0000
        faveoApiRestClient.responseAsString(response);
    }

    @Test
    public void  createTicketTest(){
        String createTicketBody ="";
        response = faveoApiRestClient.doPost(FAVEO_API_MAIN_URL.concat("tickets"), createTicketBody);
        faveoApiRestClient.responseAsString(response);
    }


}

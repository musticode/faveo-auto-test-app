package org.testapp.Api.Test;

import com.jayway.restassured.response.ValidatableResponse;
import org.testapp.Api.PropertyManager.FaveoApiPropertyManager;
import org.testapp.Api.RestClient.abstraction.RestClient;
import org.testapp.Api.RestClient.abstraction.FaveoApiRestClient;
import org.testng.annotations.Test;

public class FaveoApiTest {

    String FAVEO_API_MAIN_URL = FaveoApiPropertyManager.getInstance().getFaveoApiUrl();


    ValidatableResponse response;
    RestClient faveoApiRestClient = new FaveoApiRestClient();

    @Test
    public void getAllMspTickets(){
        response = faveoApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("tickets"));
        faveoApiRestClient.responseAsString(response);
    }

}

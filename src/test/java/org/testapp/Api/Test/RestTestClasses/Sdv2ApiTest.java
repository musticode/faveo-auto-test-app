package org.testapp.Api.Test.RestTestClasses;

import com.jayway.restassured.response.ValidatableResponse;
import org.testapp.Api.DataProvider.FaveoApi.Ticket.CreateTicketRequestBody;
import org.testapp.Api.PropertyManager.Sdv2ApiPropertyManager;
import org.testapp.Api.RestClient.abstraction.Sdv2ApiRestClient;
import org.testapp.Api.RestClient.abstraction.RestClient;
import org.testapp.Ui.Pages.Faveo.Client.TicketCreatePage;
import org.testng.annotations.Test;

public class Sdv2ApiTest {
    //constant url
    String FAVEO_API_MAIN_URL = Sdv2ApiPropertyManager.getInstance().getFaveoApiUrl();


    ValidatableResponse response;
    RestClient sdv2ApiRestClient = new Sdv2ApiRestClient();

    //ticket create body
    CreateTicketRequestBody createTicketRequestBody = new CreateTicketRequestBody();

    @Test
    public void getAllMspTickets(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("tickets"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void  getOneTicketTest(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("tickets?filter[id][]=1")); //&filter[ticket_number]=AAAA-0000-0000
        sdv2ApiRestClient.responseAsString(response);
    }

/*
    String createTicketBody= "";
    @Test
    public void  createTicketTest(){
        response = sdv2ApiRestClient.doPost(FAVEO_API_MAIN_URL.concat("tickets"),createTicketBody );
        sdv2ApiRestClient.responseAsString(response);
    }*/

    @Test
    public void getLocations(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("locations"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getLocationWithId(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("locations/" +"1" ));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getOrganizations(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("organizations"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getOrganizationWithId(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("organizations/" +"9" ));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getSlaPlans(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("slaplans"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getSlaPlanFiltered(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("slaplans" + "?filter[name]=Sla 1)"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTeams(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("teams"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTeamWithId(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("teams/" +"3" ));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTicketCollaborators(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("ticketcollaborators"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTicketCollaboratorWithId(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("ticketcollaborators/" +"1" ));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTicketCollaboratorWithUser(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("ticketcollaborators/" +"1" + "/user" ));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTicketPrioritiesWithFilter(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("ticketpriorities?name='Low'"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTicketPriority(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("ticketpriorities/" +"1" ));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTicketStatuses(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("ticketstatuses"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTicketStatusWithId(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("ticketstatuses/" +"1" ));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTicketThreads(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("ticketthreads"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getTicketThreadWithId(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("ticketthreads/" +"2" ));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getUsers(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("users"));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getUserWithFilterRole(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("users" +"?filter[role]=staff" ));
        sdv2ApiRestClient.responseAsString(response);
    }

    @Test
    public void getUserWithId(){
        response = sdv2ApiRestClient.doGet(FAVEO_API_MAIN_URL.concat("users/" +"1" ));
        sdv2ApiRestClient.responseAsString(response);
    }





}

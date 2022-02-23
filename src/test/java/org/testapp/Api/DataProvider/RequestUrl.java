package org.testapp.Api.DataProvider;

import org.testapp.Api.PropertyManager.PropertyManager;
import org.testng.annotations.Test;

public class RequestUrl {

    private String API_KEY = PropertyManager.getInstance().getApiKey();
    private String APP_URL = PropertyManager.getInstance().getUrl();
    private String MSP_ID = PropertyManager.getInstance().getMspId();
    private String ID = PropertyManager.getInstance().getId();
    private String COMPANY_ID = PropertyManager.getInstance().getCompanyId();
    private String STAFF_UNIQUE_ID = PropertyManager.getInstance().getStaffUniqueId();
    private String USER_UNIQUE_ID = PropertyManager.getInstance().getUserUniqueId();
    private String USER_ID_URL = PropertyManager.getInstance().getUserIdUrl();
    private String STAFF_ID_URL = PropertyManager.getInstance().getStaffIdUrl();

    public String getMspCreateRequestUrl(){
        return APP_URL.concat("/pim/msps");
    }
    public String getMspUpdateRequestUrl(){
        return APP_URL.concat("/pim/msps/"+ID);
    }
    public String getMspDeleteRequestUrl(){
        return APP_URL.concat("/pim/msps/"+ID);
    }
    public String getMspHoldRequestUrl(){
        return APP_URL.concat("/pim/msps/"+ID+"/hold");
    }
    public String getMspUnholdRequestUrl(){
        return APP_URL.concat("/pim/msps/"+ID+"/unhold");
    }
    public String getRoleCreateRequestUrl(){
        return APP_URL.concat("/pim/roles");
    }
    public String getAdminCreateRequestUrl(){
        return APP_URL.concat("/pim/staffs");
    }
    public String getCompanyCreateRequestUrl(){
        return APP_URL.concat("/pim/companies");
    }
    public String getCompanyUpdateRequestUrl(){
        return APP_URL.concat("/pim/companies/"+COMPANY_ID);
    }
    public String getCompanyDeleteRequestUrl(){
        return APP_URL.concat("/pim/companies/"+COMPANY_ID);
    }
    public String getStaffCreateRequestUrl(){
        return APP_URL.concat("/pim/staffs");
    }
    public String getStaffUpdateRequestUrl(){
        return APP_URL.concat("/pim/staffs/"+STAFF_ID_URL);
    }
    public String getStaffDeleteRequestUrl(){
        return APP_URL.concat("/pim/staffs/"+STAFF_ID_URL);
    }
    public String getUserCreateRequestUrl(){
        return APP_URL.concat("/pim/users");
    }
    public String getUserUpdateRequestUrl(){
        return APP_URL.concat("/pim/users/"+USER_ID_URL);
    }
    public String getUserDeleteRequestUrl(){
        return APP_URL.concat("/pim/users/"+USER_ID_URL);
    }



}

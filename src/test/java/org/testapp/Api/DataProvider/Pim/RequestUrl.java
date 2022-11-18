package org.testapp.Api.DataProvider.Pim;

import org.testapp.Api.PropertyManager.PimApiPropertyManager;

public class RequestUrl {

    private String API_KEY = PimApiPropertyManager.getInstance().getApiKey();
    private String APP_URL = PimApiPropertyManager.getInstance().getUrl();
    private String MSP_ID = PimApiPropertyManager.getInstance().getMspId();
    private String ID = PimApiPropertyManager.getInstance().getId();
    private String COMPANY_ID = PimApiPropertyManager.getInstance().getCompanyId();
    private String STAFF_UNIQUE_ID = PimApiPropertyManager.getInstance().getStaffUniqueId();
    private String USER_UNIQUE_ID = PimApiPropertyManager.getInstance().getUserUniqueId();
    private String USER_ID_URL = PimApiPropertyManager.getInstance().getUserIdUrl();
    private String STAFF_ID_URL = PimApiPropertyManager.getInstance().getStaffIdUrl();

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

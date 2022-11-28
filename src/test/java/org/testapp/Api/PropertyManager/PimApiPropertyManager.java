package org.testapp.Api.PropertyManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PimApiPropertyManager {
    private static PimApiPropertyManager instance;
    private static final Object lock = new Object();
    private String configFilePath = "src/test/resources/configuration/apiConfig.properties";

    private String apiKey;
    private String url;
    private String mspId;
    private String id;
    private String companyId;
    private String staffUniqueId;
    private String userUniqueId;
    private String staffIdurl;
    private String userIdurl;


    public static PimApiPropertyManager getInstance(){
        if(instance == null){
            synchronized (lock){
                instance = new PimApiPropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }
    private void loadData(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(configFilePath));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("File is not found");
        }
        apiKey = properties.getProperty("api_key");
        url = properties.getProperty("url");
        mspId = properties.getProperty("msp_id");
        id = properties.getProperty("id");
        companyId = properties.getProperty("company_id");
        staffUniqueId = properties.getProperty("staff_unique_id");
        userUniqueId = properties.getProperty("user_unique_id");
        staffIdurl = properties.getProperty("staff_id_url");
        userIdurl = properties.getProperty("user_id_url");

    }

    public String getApiKey(){
        return apiKey;
    }
    public String getUrl(){
        return url;
    }
    public String getMspId(){return mspId;}
    public String getId(){return  id;}
    public String getCompanyId(){return companyId;}
    public String getStaffUniqueId(){return staffUniqueId;}
    public String getUserUniqueId(){return userUniqueId;}
    public String getStaffIdUrl(){return staffIdurl;}
    public String getUserIdUrl(){return userIdurl;}



}

package org.testapp.Api.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private String configFilePath = "src/test/resources/apiConfig.properties";

    private String apiKey;
    private String url;
    private String mspId;
    private String id;
    private String companyId;
    private String staffUniqueId;
    private String userUniqueId;

    public static PropertyManager getInstance(){
        if(instance == null){
            synchronized (lock){
                instance = new PropertyManager();
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


}

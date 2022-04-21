package org.testapp.Api.PropertyManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TenantPropertyManager {
    private static TenantPropertyManager instance;
    private static final Object lock = new Object();
    private String configFilePath = "src/test/resources/apiConfig.properties";


    private String tenantUrl;
    private String tenantEmail;
    private String tenantPassword;
    private String tenantNewPassword;
    private String tenantApiKey;
    private String tenantCompanyName;
    private String tenantSubDomain;
    private String tenantUserName;



    public static TenantPropertyManager getInstance(){
        if(instance == null){
            synchronized (lock){
                instance = new TenantPropertyManager();
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
        tenantUrl = properties.getProperty("tenant_url");
        tenantEmail = properties.getProperty("tenant_email");
        tenantPassword = properties.getProperty("tenant_password");
        tenantNewPassword = properties.getProperty("tenant_new_password");
        tenantApiKey = properties.getProperty("tenant_api_key");
        tenantCompanyName = properties.getProperty("tenant_company_name");
        tenantSubDomain = properties.getProperty("tenant_subdomain");
        tenantUserName = properties.getProperty("tenant_user_name");


    }

    public String getTenantUrl() {
        return tenantUrl;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public String getTenantApiKey() {
        return tenantApiKey;
    }

    public String getTenantCompanyName() {
        return tenantCompanyName;
    }

    public String getTenantNewPassword() {
        return tenantNewPassword;
    }

    public String getTenantPassword() {
        return tenantPassword;
    }

    public String getTenantSubDomain() {
        return tenantSubDomain;
    }

    public String getTenantUserName() {
        return tenantUserName;
    }

}

package org.testapp.Ui.DataProvider;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private String configFilePath = "src/test/resources/uiConfig.properties";

    private String appUrl;
    private String testEmail;
    private String testPassword;

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
        appUrl = properties.getProperty("app_url");
        testEmail  = properties.getProperty("test_email");
        testPassword = properties.getProperty("test_password");
    }

    public String getAppUrl(){
        return appUrl;
    }
    public String getTestEmail(){return testEmail;}
    public String getTestPassword(){return  testPassword;}

}

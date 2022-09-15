package org.testapp.Api.PropertyManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FaveoApiPropertyManager {
    private static FaveoApiPropertyManager instance;
    private static final Object lock = new Object();
    private String configFilePath = "src/test/resources/apiConfig.properties";

    private String faveoApiUrl;
    private String authorization;

    public static FaveoApiPropertyManager getInstance(){
        if (instance == null){
            synchronized (lock){
                instance = new FaveoApiPropertyManager();
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
        faveoApiUrl = properties.getProperty("faveo_api_url");
        authorization = (String) properties.get("authorization_key");
    }

    public String getFaveoApiUrl() {
        return faveoApiUrl;
    }

    public String getAuthorization() {
        return authorization;
    }
}

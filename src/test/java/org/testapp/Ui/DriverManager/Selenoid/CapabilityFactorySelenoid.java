package org.testapp.Ui.DriverManager.Selenoid;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityFactorySelenoid {

    public DesiredCapabilities desiredCapabilities;

    public DesiredCapabilities getSelenoidCapability(String browserName){
        if(browserName.equals("chrome")){
            desiredCapabilities = DesiredCapSelenoid.getChromeDesiredCapabilities();
        }else if(browserName.equals("firefox")){
            desiredCapabilities = DesiredCapSelenoid.getFirefoxDesiredCapabilities();
        }else if(browserName.equals("opera")){
            desiredCapabilities = DesiredCapSelenoid.getOperaDesiredCapabilities();
        }
        return desiredCapabilities;

    }
}

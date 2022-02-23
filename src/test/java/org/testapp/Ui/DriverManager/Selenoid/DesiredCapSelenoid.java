package org.testapp.Ui.DriverManager.Selenoid;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class DesiredCapSelenoid {

    public static DesiredCapabilities getFirefoxDesiredCapabilities() {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("browserVersion", "94.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        return capabilities;
    }

    public static DesiredCapabilities getChromeDesiredCapabilities() {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "95.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        return capabilities;
    }

    public static DesiredCapabilities getOperaDesiredCapabilities() {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability("browserName", "opera");
        capabilities.setCapability("browserVersion", "80.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        return capabilities;
    }


}

package org.testapp.Ui.DriverManager;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverOptions {

    public ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("ignore-certificate-errors");
        return chromeOptions;
    }
    public static FirefoxOptions getFirefoxOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        return firefoxOptions;
    }
}

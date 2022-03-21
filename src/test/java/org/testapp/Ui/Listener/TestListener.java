package org.testapp.Ui.Listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.DriverManager.DriverManager;
import org.testapp.Ui.Test.TestBase.BaseTest;
import org.testapp.Ui.Util.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends DriverManager implements ITestListener {
//    WebDriver driver;
    String filePath = "src/test/java/org/testapp/Ui/ScreenShots";


    public void onTestStart(ITestResult result){
        System.out.println("Test started: "+result.getName());
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Successfully Finished: " +result.getName());
    }


    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " +result.getName());

        //allure attachment instances


//            TestUtil.captureScreenshot(result.getName().toString());

        //allure screenshot
        TestUtil.saveScreenShotAsPNG(driver);

    }


    @Attachment(value = "Page screenshot ", type = "image/png")
    public byte [] saveScreenShotAsPNG(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }



    /*    public void takeScreenShot(String methodName, WebDriver driver){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in d drive with test method name
            try {
                FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
                System.out.println("***Placed screen shot in "+filePath+" ***");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " +result.getName());
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage: " +result.getName());
    }
    public void onStart(ITestContext context) {
        System.out.println("This is onStart method: " +context.getOutputDirectory());
    }
    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish method: " +context.getPassedTests());
        System.out.println("This is onFinish method: " +context.getFailedTests());
    }


}

package Listeners;

import Utililties.LogUtility;
import Utililties.classesUtility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static DriverFactory.DriverFactory.getDriver;

public class ITestListener implements org.testng.ITestListener {

    public void onTestStart(ITestResult result) {
        LogUtility.info("TEST CASE START--"+result.getName());

    }

    public void onTestSuccess(ITestResult result) {
        LogUtility.info("TEST PASS--"+result.getStatus());
    }

    public void onTestFailure(ITestResult result) {
        LogUtility.error("TEST FAIL--"+result.getStatus());
    }

    public void onTestSkipped(ITestResult result) {
        LogUtility.info("TEST SKIPPED"+result.getStatus());
    }

    public void onStart(ITestContext context) {
        LogUtility.info("TEST START--"+context.getName());
    }

    public void onFinish(ITestContext context) {
        LogUtility.info("TEST FINISH--"+context.getName());

    }

}

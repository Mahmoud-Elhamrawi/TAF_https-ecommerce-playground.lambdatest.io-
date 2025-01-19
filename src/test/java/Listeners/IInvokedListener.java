package Listeners;

import Utililties.LogUtility;
import Utililties.classesUtility;
import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static DriverFactory.DriverFactory.getDriver;

public class IInvokedListener implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            LogUtility.info("error------");
            classesUtility.takeScreenShot(getDriver(), testResult.getName());
        }
        File logFile = classesUtility.getLastFileLog(LogUtility.logPath);
        try {
            Allure.addAttachment("LOGS", Files.readString(logFile.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

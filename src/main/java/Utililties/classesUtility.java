package Utililties;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class classesUtility {


    //TODO :: Click on Element
    public static void clickEle(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).clear();
    }

    //TODO :: Enter Text
   public static void enterText(WebDriver driver , By locator , String text)
   {
       new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
       driver.findElement(locator).sendKeys(text);
   }

   //TODo :: getText
    public static String  getTextFromEle(WebDriver driver , By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    //TODO :: Scrolling
    public static void scrollToEle(WebDriver driver , By locator)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0]scrollIntoView();",driver.findElement(locator));
    }

    //TODO::Take screenshot
    public static final String screenPath = "test-outputs/ScreenShots/";
    public static void takeScreenShot(WebDriver driver , String screenName)
    {
        try {
            File screenSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenDis = new File(screenPath + screenName + "_" + timeStamp() + ".png");
            FileUtils.copyFile(screenSrc, screenDis);
            Allure.addAttachment(screenName, Files.newInputStream(Path.of(screenDis.getPath())));
        }catch (Exception e)
        {
            LogUtility.info(e.getMessage());
        }
    }

    //TODO :: time stamp
    public static String timeStamp()
    {
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());
    }


    //TODO :: Get Latest Log File
    public static File getLastFileLog(String pathFolder)
    {
        File folder  = new File(pathFolder);
        File [] files = folder.listFiles();
        if (files.length == 0) return null;
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];
    }


    //TODO :: convert locator to Web Element
    public static WebElement convertEle(WebDriver driver , By  locator)
    {
        return driver.findElement(locator);
    }

}

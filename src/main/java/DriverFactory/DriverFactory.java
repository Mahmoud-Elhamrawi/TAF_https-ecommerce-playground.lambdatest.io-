package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {

    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>() ;

    public static void setUPDriver(String browser)
    {
        if(browser.equalsIgnoreCase("edge"))
        {
            EdgeOptions options = new EdgeOptions() ;
            options.addArguments("--start-maximized");
            threadLocal.set(new EdgeDriver(options));

        }else if (browser.equalsIgnoreCase("firefox"))
        {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            threadLocal.set(new FirefoxDriver(options));

        }else
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            threadLocal.set(new ChromeDriver(options));
        }

    }

    public static WebDriver getDriver()
    {
        return threadLocal.get();
    }


    public static void tearDownDriver(){
        getDriver().quit();
        threadLocal.remove();
    }










}

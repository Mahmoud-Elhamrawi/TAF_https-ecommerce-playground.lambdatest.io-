package TestCases;

import Utililties.DataUtility;
import Utililties.LogUtility;
import Listeners.IInvokedListener;
import Listeners.ITestListener;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

@Listeners({IInvokedListener.class , ITestListener.class })
public class TC02_LoginTest {


    @BeforeClass
    public void setUp() {
        String browser = System.getProperty("browser") != null? System.getProperty("browser"):DataUtility.readPropertyFile("ENV","browserName");
        setUPDriver(browser);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("ENV","HomePageUrl"));
    }

    @Description("login with valid userName and valid password")
    @Test
    public void validLoginTC()
    {
        LogUtility.info("home url : " +getDriver().getCurrentUrl());





    }



    @AfterMethod
    public void tearDown()
    {
       tearDownDriver();
    }


}

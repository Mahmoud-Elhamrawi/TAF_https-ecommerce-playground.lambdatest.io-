package TestCases;

import Pages.P01_HomePage;
import Utililties.DataUtility;
import Utililties.classesUtility;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class TC01_HomePageTest {

    @BeforeClass
    public void setUp() {
        String browser = System.getProperty("browser") != null? System.getProperty("browser"): DataUtility.readPropertyFile("ENV","browserName");
        setUPDriver(browser);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("ENV","HomePageUrl"));
    }

   @Description("click on register link")
    @Test
    public void navigateToRegisterPage()
    {
        new P01_HomePage(getDriver()).clickOnRegisterLink() ;
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()) , DataUtility.readPropertyFile("ENV","RegisterLink"));

    }


    @Description("click on login link")
    @Test
    public void navigateToLoginPage()
    {
        new P01_HomePage(getDriver()).clickOneLoginLink() ;
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()) , DataUtility.readPropertyFile("ENV","LoginLink"));
    }

    @AfterMethod
    public void tearDown()
    {
        tearDownDriver();
    }



}

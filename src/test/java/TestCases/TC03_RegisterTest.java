package TestCases;

import Pages.P01_HomePage;
import Pages.P03_RegisterPage;
import Pages.P04_ConfirmRegister;
import Utililties.DataUtility;
import Utililties.LogUtility;
import Utililties.classesUtility;
import io.qameta.allure.Description;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utililties.classesUtility.convertEle;

public class TC03_RegisterTest {


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

        new P03_RegisterPage(getDriver()).typingInfoRegistration(
                DataUtility.readJsonFile("registerData","firstName"),
                DataUtility.readJsonFile("registerData","lastName"),
                DataUtility.readJsonFile("registerData","email"),
                DataUtility.readJsonFile("registerData","phone"),
                DataUtility.readJsonFile("registerData","password"),
                DataUtility.readJsonFile("registerData","cPasswrod")
                );

        Assert.assertEquals(new P04_ConfirmRegister(getDriver()).assertOnMegSuccess(),DataUtility.readPropertyFile("ENV","MessageSuccess"));
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","RegisterSuccessLink"));
    }








    @AfterMethod
    public void tearDown()
    {
        tearDownDriver();
    }


}

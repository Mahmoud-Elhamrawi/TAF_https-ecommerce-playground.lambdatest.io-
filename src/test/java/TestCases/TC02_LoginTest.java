package TestCases;

import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Pages.P04_ConfirmRegister;
import Pages.P05_AccountSetting;
import Utililties.DataUtility;
import Utililties.LogUtility;
import Listeners.IInvokedListener;
import Listeners.ITestListener;
import Utililties.classesUtility;
import io.qameta.allure.Description;
import org.testng.Assert;
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
        new P01_HomePage(getDriver())
                .clickOneLoginLink() ;
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","LoginLink"));

         new P02_LoginPage(getDriver())
                 .validLoginTC(DataUtility.readJsonFile("loginData","email"),DataUtility.readJsonFile("loginData","password"));

        //Assert on success of login
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","LoginSuccessLink"));

        // navigate to home page
        new P05_AccountSetting(getDriver()).navigateToHomePage() ;

        //assert on home page  URL
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","HomePageUrl"));


    }



    @AfterMethod
    public void tearDown()
    {
       tearDownDriver();
    }


}

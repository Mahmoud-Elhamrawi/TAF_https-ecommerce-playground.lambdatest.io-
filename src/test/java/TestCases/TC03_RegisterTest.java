package TestCases;

import Pages.*;
import Utililties.DataUtility;
import Utililties.classesUtility;
import io.qameta.allure.Description;
import org.testng.Assert;
import Listeners.IInvokedListener;
import Listeners.ITestListener;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.Instant;

import static DriverFactory.DriverFactory.*;
@Listeners({IInvokedListener.class , ITestListener.class })
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
    public void validRegisterTC()
    {
        new P01_HomePage(getDriver()).clickOnRegisterLink() ;
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()) , DataUtility.readPropertyFile("ENV","RegisterLink"));


        // fill data to register
        new P03_RegisterPage(getDriver())
                 .typingInfoRegistration(
                DataUtility.readJsonFile("registerData","firstName"),
                DataUtility.readJsonFile("registerData","lastName"),
               "test"+Instant.now().toEpochMilli()+"@gmail.com"  ,
                //DataUtility.readJsonFile("registerData","email"),
                DataUtility.readJsonFile("registerData","phone"),
                DataUtility.readJsonFile("registerData","password"),
                DataUtility.readJsonFile("registerData","cPasswrod")
                );
        //Assert on success of register
        Assert.assertEquals(new P04_ConfirmRegister(getDriver()).assertOnMegSuccess(),DataUtility.readPropertyFile("ENV","MessageSuccess"));
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","RegisterSuccessLink"));

         // navigate to home page
          new P04_ConfirmRegister(getDriver()).navigateToAccountSetting() ;
          new P05_AccountSetting(getDriver()).navigateToHomePage() ;

          //assert on home page  URL
          Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","HomePageUrl"));

    }




    @Test(dependsOnMethods = "validRegisterTC")
    public void logOutTC()
    {
        new P01_HomePage(getDriver())
                .clickOnLogOutLink();

        //Assert on logout Url
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","LogOutLink"));
        Assert.assertEquals(new P06_LogOutPage(getDriver()).assertOnLogOutMeg(),DataUtility.readPropertyFile("ENV","LogOutMessage"));

        // go to home page
        new P06_LogOutPage(getDriver()).clickOnContinueBtn() ;
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","HomePageUrl"));
    }








    @AfterClass
    public void tearDown()
    {
        tearDownDriver();
    }


}

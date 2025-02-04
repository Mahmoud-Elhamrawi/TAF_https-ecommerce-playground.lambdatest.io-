package TestCases;

import Pages.P07_SearchPage;
import Pages.P08_ProductsList;
import Utililties.DataUtility;
import Utililties.classesUtility;
import io.qameta.allure.Description;
import org.testng.Assert;
import Listeners.IInvokedListener;
import Listeners.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

import static DriverFactory.DriverFactory.*;
@Listeners({IInvokedListener.class , ITestListener.class })
public class TC04_SearchTest {

    @BeforeClass
    public void setUp() {
        String browser = System.getProperty("browser") != null? System.getProperty("browser"): DataUtility.readPropertyFile("ENV","browserName");
        setUPDriver(browser);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("ENV","HomePageUrl"));
    }
@Description("verify search feature")
@Test
public void validSearchTC()
{
    new P07_SearchPage(getDriver())
            .searchForProduct(DataUtility.readPropertyFile("ENV","SearchWord")) ;

    Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","SearchLink"));
    Assert.assertTrue(new P08_ProductsList(getDriver()).assertOnText().contains(DataUtility.readPropertyFile("ENV","SearchWord")));



}





    @AfterMethod
    public void tearDown()
    {
        tearDownDriver();
    }




}

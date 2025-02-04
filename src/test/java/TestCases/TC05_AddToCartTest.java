package TestCases;

import Pages.P07_SearchPage;
import Pages.P08_ProductsList;
import Utililties.DataUtility;
import Utililties.LogUtility;
import Utililties.classesUtility;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class TC05_AddToCartTest {




    @BeforeClass
    public void setUp() {
        String browser = System.getProperty("browser") != null? System.getProperty("browser"): DataUtility.readPropertyFile("ENV","browserName");
        setUPDriver(browser);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("ENV","HomePageUrl"));
    }
    @Description("verify add to cart feature")
    @Test
    public void validAddToCartTC()
    {
        //search
        new P07_SearchPage(getDriver())
                .searchForProduct(DataUtility.readPropertyFile("ENV","SearchWord")) ;

        //scroll
        classesUtility.scrollToEle(getDriver(), new P08_ProductsList(getDriver()).gridLocator());

        //add to cart
         new P08_ProductsList(getDriver())
                 .addToCart() ;

         //close notification
        new P08_ProductsList(getDriver())
                .closeNotification();

         //assert on cart icon number
        Assert.assertEquals(new P08_ProductsList(getDriver()).getCartIconNumber() ,"1");
        LogUtility.info(new P08_ProductsList(getDriver()).getCartIconNumber());



    }





    @AfterMethod
    public void tearDown()
    {
        tearDownDriver();
    }





}

package TestCases;

import Pages.P07_SearchPage;
import Pages.P08_ProductsList;
import Pages.P09_CartPage;
import Utililties.DataUtility;
import Utililties.LogUtility;
import Utililties.classesUtility;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.text.DecimalFormat;
import java.time.Duration;
import static DriverFactory.DriverFactory.*;
import Listeners.IInvokedListener;
import Listeners.ITestListener;

@Listeners({IInvokedListener.class , ITestListener.class })

public class TC05_CartPageTest {


    @BeforeMethod
    public void setUp() {
        String browser = System.getProperty("browser") != null? System.getProperty("browser"): DataUtility.readPropertyFile("ENV","browserName");
        setUPDriver(browser);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("ENV","HomePageUrl"));
    }

public static float priceProd=0;
    @Description("verify user able to edit cart quantities")
    @Test(priority = 1)
    public void validAddToCartTC()
    {
        //search
        new P07_SearchPage(getDriver())
                .searchForProduct(DataUtility.readPropertyFile("ENV","SearchWord")) ;

        //scroll
        classesUtility.scrollToEle(getDriver(), new P08_ProductsList(getDriver()).gridLocator());

        LogUtility.info("product Price Before update : " + new P08_ProductsList(getDriver()).getPriceProd());

        priceProd =Float.parseFloat(new P08_ProductsList(getDriver()).getPriceProd());  //as string

        //add to cart
         new P08_ProductsList(getDriver())
                 .addToCart() ;

         //close notification
        new P08_ProductsList(getDriver())
                .closeNotification();

         //assert on cart icon number
        Assert.assertEquals(new P08_ProductsList(getDriver()).getCartIconNumber() ,"1");
        LogUtility.info(new P08_ProductsList(getDriver()).getCartIconNumber());


        //open cart page
        new P08_ProductsList(getDriver())
                .openCartPage() ;
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","CartPageLink"));

       //122.00
         //edit cart
        new P09_CartPage(getDriver())
                .editQuantityOfProduct("3") ;

        priceProd *= 3 ;
        LogUtility.info("product Price After update : " + priceProd );  //366

        Assert.assertEquals(new P09_CartPage(getDriver()).getNewPriceProd(),new DecimalFormat("#.00").format(priceProd));
        Assert.assertTrue(new P09_CartPage(getDriver()).getAlertTextUpdated().trim().contains("Success: You have modified your shopping cart!"));
     // checkout page
        new P09_CartPage(getDriver()).goToCheckOut() ;
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","CheckOutLink"));


    }



    @Description("verify user able to delete cart quantities")
    @Test(priority = 2)
    public void deleteCartQuantityTC()
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


        //open cart page
        new P08_ProductsList(getDriver())
                .openCartPage() ;
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","CartPageLink"));

        //delete cart
        new P09_CartPage(getDriver())
                .deleteQuantity() ;
        Assert.assertEquals(new P09_CartPage(getDriver()).getAlertTextDeleted().trim() , "Your shopping cart is empty!");

        //Go To home page
        new P09_CartPage(getDriver())
                .goToHomePage() ;
        Assert.assertEquals(classesUtility.assertOnUrl(getDriver()),DataUtility.readPropertyFile("ENV","HomePageUrl"));


    }




    @AfterMethod
    public void tearDown()
    {
        tearDownDriver();
    }





}

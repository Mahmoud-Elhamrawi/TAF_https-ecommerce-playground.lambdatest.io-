package Pages;

import Utililties.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;

public class P08_ProductsList {


    private final WebDriver driver;

    public P08_ProductsList(WebDriver driver)
    {
        this.driver =driver ;
    }

    private final By searchWord_h1 = By.cssSelector("div[id=\"entry_212456\"] h1");
    private final By gridItems = By.id("entry_212469");
    private final By firstProd = By.xpath("(//div[contains(@class,\"product-layout\")] )[1]");
    private final By addProdToCart_Btn = By.xpath("(//div[contains(@class,\"product-layout\")] )[1] //div[@class=\"product-action\"]//button[@title=\"Add to Cart\"]");
    private final By notificationBox = By.id("notification-box-top");
    private final By closeNotification_Btn = By.cssSelector("button[data-dismiss=\"toast\"]");
    private final By cartIconNumber = By.xpath("//div[@id=\"entry_217825\"]//span[contains(@class,'cart-item-total')]");
    private final By cartIcon  = By.cssSelector("div[id=\"entry_217825\"] a");
    private final By cartBox = By.id("cart-total-drawer");
    private final By editCartPage_Btn = By.cssSelector("div[id=\"entry_217850\"] a");

    private final By priceProd = By.xpath("(//div[contains(@class,\"product-layout\")] )[1] //div[@class=\"price\"] //span");

    public String assertOnText()
    {
        return driver.findElement(searchWord_h1).getText();
    }

    public By gridLocator()
    {
        return gridItems ;
    }


    public P09_CartPage addToCart()
    {
        new Actions(driver).moveToElement(classesUtility.convertEle(driver,firstProd)).perform();
        classesUtility.clickEle(driver,addProdToCart_Btn);

        return new P09_CartPage(driver);
    }


    public P08_ProductsList closeNotification()
    {
        classesUtility.clickEle(driver,closeNotification_Btn);
        return this;
    }

    public String getCartIconNumber()
    {
        new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(notificationBox));
        return  classesUtility.getTextFromEle(driver,cartIconNumber) ;
    }


    public P09_CartPage openCartPage()
    {
        classesUtility.clickEle(driver,cartIcon);
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(cartBox));
        classesUtility.clickEle(driver,editCartPage_Btn);
        return new P09_CartPage(driver);
    }


    public String getPriceProd()
    {
        return classesUtility.getTextFromEle(driver,priceProd).replace("$","");
    }



}

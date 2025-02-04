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

    public String assertOnText()
    {
        return driver.findElement(searchWord_h1).getText();
    }

    public By gridLocator()
    {
        return gridItems ;
    }


    public P09_AddToCartPage addToCart()
    {
        new Actions(driver).moveToElement(classesUtility.convertEle(driver,firstProd)).perform();
        classesUtility.clickEle(driver,addProdToCart_Btn);

        return new P09_AddToCartPage(driver);
    }

    public By notification()
    {
        return notificationBox ;
    }

    public P08_ProductsList closeNotification()
    {
        classesUtility.clickEle(driver,closeNotification_Btn);
        return this;
    }

    public String getCartIconNumber()
    {
        new WebDriverWait(getDriver(), Duration.ofSeconds(40)).until(ExpectedConditions.invisibilityOfElementLocated(notificationBox));
        return  classesUtility.getTextFromEle(driver,cartIconNumber) ;
    }





}

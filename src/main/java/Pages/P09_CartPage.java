package Pages;

import Utililties.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P09_CartPage {
    private final WebDriver driver;

    public P09_CartPage(WebDriver driver) {
        this.driver=driver ;
    }

    private final By quantity_inp = By.cssSelector("div[class=\"table-responsive\"] table tr input");
    private final By  refreshQuantity = By.cssSelector("div[class=\"table-responsive\"] table tr button:nth-of-type(1)");
    private final By  deleteQuantity = By.cssSelector("div[class=\"table-responsive\"] table tr button:nth-of-type(2)");

    private final By alertText_Alert = By.xpath("//ol[@class=\"breadcrumb\"] //following::div[contains(@class,'alert-dismissible')]");
    private final By deleteText_Text = By.cssSelector("div[id=\"content\"] p");
    private final By contain_Btn = By.cssSelector("div[class=\"buttons\"]");

    public P09_CartPage editQuantityOfProduct(String q)
    {
        classesUtility.clearTextFromEle(driver,quantity_inp);
        classesUtility.enterText(driver,quantity_inp,q);
        classesUtility.clickEle(driver,refreshQuantity);
        return this;
    }

    public String getAlertTextUpdated()
    {
        return classesUtility.getTextFromEle(driver,alertText_Alert);
    }

    public P09_CartPage deleteQuantity()
    {
        classesUtility.clickEle(driver,deleteQuantity);
        return this;
    }

    public String getAlertTextDeleted()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(contain_Btn));
        return classesUtility.getTextFromEle(driver,deleteText_Text);
    }

    public P01_HomePage goToHomePage()
    {
        classesUtility.clickEle(driver,contain_Btn);
        return new P01_HomePage(driver);
    }




}

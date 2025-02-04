package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P08_ProductsList {


    private final WebDriver driver;

    public P08_ProductsList(WebDriver driver)
    {
        this.driver =driver ;
    }

    private final By searchWord_h1 = By.cssSelector("div[id=\"entry_212456\"] h1");
    private final By addProdToCart_Btn = By.xpath("(//div[contains(@class,\"product-layout\")] )[1] //div[@class=\"product-action\"]//button[@title=\"Add to Cart\"]");


    public String assertOnText()
    {
        return driver.findElement(searchWord_h1).getText();
    }




}

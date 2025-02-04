package Pages;

import Utililties.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_SearchPage {
    private final WebDriver driver;


    public P07_SearchPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By search_Inp = By.xpath("(//div[contains(@class,'flex-fill')]//child::input[@name=\"search\"])[1]") ;
    private final By search_Btn = By.xpath("//button[.='Search']") ;



    public P08_ProductsList searchForProduct(String prodName)
    {
        classesUtility.enterText(driver,search_Inp,prodName);
        classesUtility.clickEle(driver,search_Btn);

        return new P08_ProductsList(driver);
    }


}

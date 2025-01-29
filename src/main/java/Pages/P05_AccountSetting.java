package Pages;

import Utililties.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_AccountSetting {
    private final WebDriver driver;

    public P05_AccountSetting(WebDriver driver) {
        this.driver = driver ;
    }


    private final By home_icon = By.cssSelector("ol[class=\"breadcrumb\"] a") ;

    public P01_HomePage navigateToHomePage()
    {
        classesUtility.clickEle(driver,home_icon);
        return new P01_HomePage(driver);
    }




}

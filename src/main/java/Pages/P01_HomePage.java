package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static Utililties.classesUtility.convertEle;

public class P01_HomePage {

    public WebDriver driver ;

    public P01_HomePage(WebDriver driver)
    {
        this.driver =driver ;
    }
    //locators
     private final By myAccountBtn_DropDown = By.xpath("(//a[contains(@class,'dropdown-toggle')])[3]");
     private final By register_link = By.xpath("(//ul[contains(@class,'mz-sub-menu-96')] /li /a)[2]");
     private final By login_link = By.xpath("(//ul[contains(@class,'mz-sub-menu-96')] /li /a)[1]");


      public P03_RegisterPage clickOnRegisterLink()
      {
          new Actions(driver).moveToElement(convertEle(driver,myAccountBtn_DropDown)).click(convertEle(driver,register_link)).perform();
          return new P03_RegisterPage(driver);
      }


    public P02_LoginPage clickOnloginLink()
    {
        new Actions(driver).moveToElement(convertEle(driver,myAccountBtn_DropDown)).click(convertEle(driver,login_link)).perform();
        return new P02_LoginPage(driver);
    }





}

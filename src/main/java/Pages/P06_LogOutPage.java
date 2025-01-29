package Pages;

import Utililties.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_LogOutPage {

    public WebDriver driver ;

    public P06_LogOutPage(WebDriver driver)
    {
        this.driver=driver ;
    }

    //Locators
    private final By logOut_Text =By.xpath("//h1[contains(@class,'page-title')]");
    private final By continue_Btn = By.linkText("Continue");


    //Actions

    public String assertOnLogOutMeg()
    {
        return driver.findElement(logOut_Text).getText();
    }

    public P01_HomePage clickOnContinueBtn()
     {
         classesUtility.clickEle(driver,continue_Btn);
         return new P01_HomePage(driver);
     }



}

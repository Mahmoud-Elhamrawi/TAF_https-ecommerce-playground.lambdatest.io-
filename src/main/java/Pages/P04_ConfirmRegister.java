package Pages;

import Utililties.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_ConfirmRegister {

    private final WebDriver driver;

    public P04_ConfirmRegister(WebDriver driver) {
        this.driver = driver ;
    }

    private final By textConfirm_h1= By.xpath("//h1[contains(@class,'page-title')]");
    private final By continue_btn = By.linkText("Continue");



    public String assertOnMegSuccess()
    {
       return driver.findElement(textConfirm_h1).getText();
    }


    public P05_AccountSetting navigateToAccountSetting()
    {
        classesUtility.clickEle(driver,continue_btn);
        return new P05_AccountSetting(driver);
    }



}

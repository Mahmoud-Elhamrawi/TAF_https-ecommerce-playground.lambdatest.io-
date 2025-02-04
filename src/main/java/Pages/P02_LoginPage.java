package Pages;

import Utililties.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage {
    private final WebDriver driver;

    public P02_LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By email_inp = By.id("input-email");
    private final By password_inp = By.id("input-password");
    private final By login_Btn = By.cssSelector("input[value=\"Login\"]");

    public P05_AccountSetting validLoginTC(String email , String password)
    {
        classesUtility.enterText(driver,email_inp,email);
        classesUtility.enterText(driver,password_inp,password);
        classesUtility.clickEle(driver,login_Btn);


        return new P05_AccountSetting(driver);
    }




}

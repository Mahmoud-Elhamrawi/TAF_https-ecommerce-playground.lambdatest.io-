package Pages;

import Utililties.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_RegisterPage {
    private final WebDriver driver;

    public P03_RegisterPage(WebDriver driver) {
        this.driver = driver ;
    }

    //locators
     private final By FName_input = By.id("input-firstname");
     private final By LName_input = By.id("input-lastname");
     private final By Email_input = By.id("input-email");
     private final By Telephone_input = By.id("input-telephone");
     private final By password_input = By.id("input-password");
     private final By Confirm_input = By.id("input-confirm");
     private final By agree_checkBox = By.cssSelector("div[class=\"float-right\"] label");
     private final By Continue_btn = By.cssSelector("input[value=\"Continue\"]");


     //Actions

   public P04_ConfirmRegister typingInfoRegistration(String fName , String lName , String email , String phone , String password , String cPassword)
   {
       classesUtility.enterText(driver,FName_input,fName);
       classesUtility.enterText(driver,LName_input,lName);
       classesUtility.enterText(driver,Email_input,email);
       classesUtility.enterText(driver,Telephone_input,phone);
       classesUtility.enterText(driver,password_input,password);
       classesUtility.enterText(driver,Confirm_input,cPassword);
       classesUtility.clickEle(driver,agree_checkBox);
       classesUtility.clickEle(driver,Continue_btn);
       return new P04_ConfirmRegister(driver);
   }






}

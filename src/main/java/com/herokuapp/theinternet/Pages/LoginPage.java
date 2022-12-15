package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.name("password");
    private By loginbuttonLocator = By.tagName("button");
    private By errorMsgLocator = By.id("flash");

    public LoginPage(WebDriver driver, Logger log) {
      super(driver,log);
    }

    //Execute Login
    public SecureAreaPage login(String username, String passwd){
        log.info("Executing Login with username ["+ username +" ] " +
                "and password ["+ passwd + "]");
        type(username,usernameLocator);
        type(passwd,passwordLocator);
        click(loginbuttonLocator);
        return new SecureAreaPage(driver,log);
    }

    public void negativeLogin(String username, String passwd){
        log.info("Executing Login with username ["+ username +" ] " +
                "and password ["+ passwd + "]");
        type(username,usernameLocator);
        type(passwd,passwordLocator);
        click(loginbuttonLocator);
    }

    public void waitForErrorMsg(){
        waitForVisibilityOf(errorMsgLocator, 5);
    }

    public String getErrorMsgText(){
        return find(errorMsgLocator).getText();
    }
}

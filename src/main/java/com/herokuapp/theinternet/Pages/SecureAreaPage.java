package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject{

    private String pageUrl = "https://the-internet.herokuapp.com/secure";

    private By logOutButton = By.xpath("//*[@id=\"login\"]/button/i");
    private By message = By.id("flash-messages");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //get url variable from pageobject
    public String getPageUrl(){
        return pageUrl;
    }

    //verification if logout button is visible on the page
    public boolean isLOgOutBUttonVisible(){
        return find(logOutButton).isDisplayed();
    }

    //return text from success message
    public String getSuccessMsgText(){
        return find(message).getText();
    }

}

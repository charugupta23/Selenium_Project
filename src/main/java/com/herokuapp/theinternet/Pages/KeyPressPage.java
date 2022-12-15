package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressPage extends BasePageObject{

    private By resultTextLocator = By.id("result");
    private By body = By.xpath("//body");

    private String pageUrl = "http://the-internet.herokuapp.com/key_presses";

    public KeyPressPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open KeyPressesPage with it's url */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    public void pressKey(Keys key){
        log.info("Key Pressed : "+ key.name());
        pressKey(body,key);
    }

    public String getResultText(){
        String result = find(resultTextLocator).getText();
        log.info("You Entered : " +result);
        return result;
    }
}

package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage extends BasePageObject{

    private By clickForJSAlertButtonLocator =
            By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
    private By clickForJSConfirmButtonLocator =
            By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
    private By clickForJSPromptButtonLocator =
            By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");
    private By resultTextLocator =
            By.id("result");

    public JavaScriptAlertPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openJSAlert(){
        log.info("clicking on 'click on JS alert' button to open alert");
        click(clickForJSAlertButtonLocator);
    }

    public void openJSConfirm(){
        log.info("clicking on 'click on JS alert' button to open alert");
        click(clickForJSConfirmButtonLocator);
    }

    public void openJSPrompt(){
        log.info("clicking on 'click on JS alert' button to open alert");
        click(clickForJSPromptButtonLocator);
    }

    public String getAlertText(){
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert Says : "+alertText);
        return alertText;
    }

    public void acceptAlert(){
        log.info("switching to alert and press OK");
        Alert alert = switchToAlert();
        alert.accept();
    }

    public void dissmissAlert(){
        log.info("switching to alert and pressing ok");
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    public void typeTextIntoAlert(String text){
        log.info("Typing text into alert and pressing ok");
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText(){
        String result = find(resultTextLocator).getText();
        log.info("Result Text : "+result);
        return result;
    }
}

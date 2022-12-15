package com.herokuapp.theinternet.alertspagetests;

import com.herokuapp.theinternet.Pages.JavaScriptAlertPage;
import com.herokuapp.theinternet.Pages.WelcomePage;
import com.herokuapp.theinternet.base.BaseTest.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends TestUtilities {
    @Test
    public void jsAlertTest(){
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();
        sleep(2000);
        JavaScriptAlertPage javaScriptAlertPage = welcomePage.openAlertsPage();
        javaScriptAlertPage.openJSAlert();
        sleep(2000);
        String alertTxt = javaScriptAlertPage.getAlertText();
        javaScriptAlertPage.acceptAlert();
        sleep(2000);
    }

    @Test
    public void jsConfirmAlert(){
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();
        sleep(2000);
        JavaScriptAlertPage javaScriptAlertPage = welcomePage.openAlertsPage();
        javaScriptAlertPage.openJSConfirm();
        String alertMessage = javaScriptAlertPage.getAlertText();
        javaScriptAlertPage.dissmissAlert();
        String result = javaScriptAlertPage.getResultText();
        Assert.assertTrue(alertMessage.equals("I am a JS Confirm"));
        Assert.assertTrue(result.equals("You clicked: Cancel"));
    }

    @Test
    public void jsPromptalert(){
        log.info("starting jsDissmissText.");
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();
        sleep(2000);
        JavaScriptAlertPage javaScriptAlertPage = welcomePage.openAlertsPage();
        javaScriptAlertPage.openJSPrompt();
        sleep(2000);
        String alertMsg = javaScriptAlertPage.getAlertText();
        javaScriptAlertPage.typeTextIntoAlert("Hello, I am Charu!!");
        String result = javaScriptAlertPage.getResultText();
        Assert.assertTrue(alertMsg.equals("I am a JS prompt"));
    }
}

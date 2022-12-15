package com.herokuapp.theinternet.windowstests;

import com.herokuapp.theinternet.Pages.NewWindowPage;
import com.herokuapp.theinternet.Pages.WelcomePage;
import com.herokuapp.theinternet.Pages.WindowPage;
import com.herokuapp.theinternet.base.BaseTest.TestUtilities;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities{
    @Test
    public void newWindowTest(){
        log.info("Starting New WindowTest");

        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        WindowPage windowPage = welcomePage.openMultipleWindowPage();
        windowPage.openNewWindow();

        NewWindowPage newWindowPage = windowPage.switchToNewWindow();

        //String pageSource = newWindowPage.getCurrentPageSource();
       // Assert.assertTrue(pageSource.contains("New Window"), "New window doesn't contain the text.");
    }

}

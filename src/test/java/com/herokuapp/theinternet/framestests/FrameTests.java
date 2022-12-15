package com.herokuapp.theinternet.framestests;

import com.herokuapp.theinternet.Pages.FramePage;
import com.herokuapp.theinternet.Pages.WelcomePage;
import com.herokuapp.theinternet.base.BaseTest.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests extends TestUtilities {

    @Test
    public void frametest(){
        log.info("iFrame Tests is starting..");
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        sleep(5000);
        welcomePage.scrollToBottom();
        sleep(5000);

        FramePage framePage = welcomePage.openFramePage();
        String editorText = framePage.getEditorText();
        Assert.assertTrue(editorText.contains("Your content goes here"));
    }
}

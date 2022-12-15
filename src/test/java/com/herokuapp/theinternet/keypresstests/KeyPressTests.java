package com.herokuapp.theinternet.keypresstests;

import com.herokuapp.theinternet.Pages.KeyPressPage;
import com.herokuapp.theinternet.base.BaseTest.TestUtilities;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressTests extends TestUtilities {

    @Test
    public void keypresstest(){
        log.info("Starting pressKeyTest");

        // open KeyPressesPage
        KeyPressPage keyPressesPage = new KeyPressPage(driver, log);
        keyPressesPage.openPage();

        // Push keyboard key
        keyPressesPage.pressKey(Keys.ENTER);

        // Get Results text
        String result = keyPressesPage.getResultText();

        // Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: ENTER"));
    }
}

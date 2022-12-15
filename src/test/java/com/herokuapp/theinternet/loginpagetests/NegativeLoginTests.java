package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.Pages.LoginPage;
import com.herokuapp.theinternet.Pages.WelcomePage;
import com.herokuapp.theinternet.base.BaseTest.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({ "username", "password", "expectedMessage" })
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting negativeTest");

        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        LoginPage loginPage = welcomePage.openFormAuthenticationPage();

        loginPage.login(username,password);



        // Verification
        String message = loginPage.getErrorMsgText();
        Assert.assertTrue(message.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + message);
    }
}

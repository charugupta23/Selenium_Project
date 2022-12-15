package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.Pages.LoginPage;
import com.herokuapp.theinternet.Pages.SecureAreaPage;
import com.herokuapp.theinternet.Pages.WelcomePage;
import com.herokuapp.theinternet.base.BaseTest.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {
    @Test
    public void logInTest() {
        log.info("Starting logIn test");

        WelcomePage welcomePage = new WelcomePage(driver,log);
        // open main page
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.openFormAuthenticationPage();

        // execute login
        SecureAreaPage secureAreaPage = loginPage.login("tomsmith","SuperSecretPassword!");

        // verifications
        // new url
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        // log out button is visible
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed(),
                "logOutButton is not visible.");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

    }
}
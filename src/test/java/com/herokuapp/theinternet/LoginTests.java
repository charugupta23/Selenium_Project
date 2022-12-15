package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginTests {
    private WebDriver driver;
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    private void setUp(String browser){
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Do not know how to start browser "+browser + ", starting chrome browser instead.");
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
        }
        System.out.println("Starting login test.");
        //Create driver
        //sleep for 3 seconds
        sleep(2000);
        //maximize driver window
        driver.manage().window().maximize();
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1,groups = {"positiveTests","smokeTests"})
    public void positiveLoginTest(){
        //open test page
        String url = "https://the-internet.herokuapp.com/secure";
        driver.get(url);
        System.out.println("Page is open...");
        sleep(1000);

        //enter username
        //WebElement username = driver.findElement(By.id("username"));
        //putting hash before id works as is in xpath or css selector
        WebElement username = driver.findElement(By.cssSelector("#username"));
        username.sendKeys("tomsmith");
        sleep(1000);

        //enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");
        sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //click login button
        WebElement loginbutton = driver.findElement(By.tagName("button"));
        wait.until(elementToBeClickable(loginbutton));
        loginbutton.click();
        sleep(1000);

        //verification:
            //new url
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"actual and expected url are not same.");

            //visible logout button
        WebElement logoutbutton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logoutbutton.isDisplayed(), "logout button is not displayed.");

            //successful message appears
        WebElement successmsg = driver.findElement(By.cssSelector("#flash"));
        String expectedMsg = "You logged into a secure area!";
        String actualMsg = successmsg.getText();
        //Assert.assertEquals(actualMsg,expectedMsg,"Message are not same.");
        Assert.assertTrue(actualMsg.contains("You logged into a secure area!"),"Message are not same.");

    }

    @Parameters({ "username","password","expectedmsg" })
    @Test(priority = 2,groups = {"nativeTests","smokeTests"})
    public void NegativeLoginTests(
            String username,String password, String expectedmsg)
            throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //open test page
        String url = "https://the-internet.herokuapp.com/secure";
        driver.get(url);
        System.out.println("Page is open...");
        sleep(1000);

        System.out.println("Negative LoginTests statrts with "+username+" and "+password);
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(username);
        sleep(1000);

        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys(password);
        sleep(1000);

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        sleep(1000);

        WebElement errorMsg = driver.findElement(By.id("flash"));
        //String expectedMsg = "Your username is invalid!";
        //String actualMsg = errorMsg.getText();
        //Assert.assertEquals(errorMsg.getText(),expectedMsg);
        Assert.assertTrue(errorMsg.getText().contains(expectedmsg));
        driver.quit();
    }

    @AfterMethod(alwaysRun = true)
    private void tearDown(){
        //close browser
        //driver.close();
        driver.quit();
    }
    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

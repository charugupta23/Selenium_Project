package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExceptionsTests {
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
        //System.out.println("Starting login test.");
        //Create driver
        //sleep for 3 seconds
        sleep(2000);
        //maximize driver window
        driver.manage().window().maximize();
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void notVisibleTest(){
        //open browser
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        sleep(2000);

        WebElement btnStart = driver.findElement(By.xpath("//div[@id='start']/button"));
        btnStart.click();
        sleep(2000);
        System.out.println("start button clicked..");
        WebElement finishElement = driver.findElement(By.id("finish"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(finishElement));

        String finishTxt = finishElement.getText();
        Assert.assertTrue(finishTxt.contains("Hello World!"),
                "Finish Text: " + finishTxt);


    }

    @Test(priority = 2)
    public void timeoutTest(){
        //open browser
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        sleep(2000);

        WebElement btnStart = driver.findElement(By.xpath("//div[@id='start']/button"));
        btnStart.click();
        sleep(2000);
        System.out.println("start button clicked..");
        WebElement finishElement = driver.findElement(By.id("finish"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(finishElement));
        }catch (TimeoutException e){
            System.out.println("Exception catched: " + e.getMessage());
            sleep(3000);
        }

        String finishTxt = finishElement.getText();
        Assert.assertTrue(finishTxt.contains("Hello World!"),
                "Finish Text: " + finishTxt);


    }

    @Test(priority = 3)
    public void noSuchElementTest(){
        //open browser
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        sleep(2000);

        WebElement btnStart = driver.findElement(By.xpath("//div[@id='start']/button"));
        btnStart.click();
        sleep(2000);
        System.out.println("start button clicked..");
        //WebElement finishElement = driver.findElement(By.id("finish"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("finish"),"Hello World!")), "Couldn't verify the text Hello World");

        WebElement finishElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.id("finish")));
        String finishTxt = finishElement.getText();
        Assert.assertTrue(finishTxt.contains("Hello World!"),
                "Finish Text: " + finishTxt);
    }

    @Test
    public void staleElementTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkBox = driver.findElement(By.id("checkbox"));
        WebElement btnRemove = driver.findElement
                (By.xpath("//button[contains(text(), 'Remove')]"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        btnRemove.click();
        /*wait.until(ExpectedConditions.invisibilityOf(checkBox));
        Assert.assertFalse(checkBox.isDisplayed(),"checkbox gone");
        */
        /*Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(checkBox)),
                "Checkbox is visible, but shouldn't be.");*/

        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(checkBox)),
                "Checkbox is visible, but shouldn't be.");

        WebElement btnAdd = driver.findElement(By.xpath("//button[contains(text(), 'Add')]"));
        btnAdd.click();
        //WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox1 = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("checkbox")));
        Assert.assertTrue(checkbox1.isDisplayed(),"checkbox should be visible.");
    }

    @Test
    public void disabledElementTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement btnEnable = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
        WebElement txtField = driver.findElement(By.cssSelector("#input-example > input[type=text]"));
        btnEnable.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(txtField));
        txtField.click();
        txtField.sendKeys("type here");
        Assert.assertTrue(txtField.getAttribute("value").contains("type here"));
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

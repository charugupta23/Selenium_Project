package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage extends BasePageObject{

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By twoCheckBoxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By alertLocator = By.linkText("JavaScript Alerts");
    private By newWindowLocator = By.linkText("Multiple Windows");
    private By iFrameLocator = By.linkText("WYSIWYG Editor");
    private By imageUploadLocator = By.linkText("File Download");

    private String pageUrl = "https://the-internet.herokuapp.com/";

    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //open welcome page with its url
    public void openPage(){
        log.info("Open page Url: "+pageUrl);
        driver.get(pageUrl);
        log.info("Page Opened..");
    }

    //open login page by clicking on form authentication page
    public LoginPage openFormAuthenticationPage(){
        log.info("Open form authentication page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver,log);
    }

    public CheckboxPage openTwoCheckboxesPage(){
        log.info("Open checkbox page");
        click(twoCheckBoxesLinkLocator);
        return new CheckboxPage(driver,log);
    }

    public DropDownPage openDropdownPage() {
        log.info("open drodown page.");
        click(dropdownLinkLocator);
        return new DropDownPage(driver,log);
    }

    public JavaScriptAlertPage openAlertsPage(){
        log.info("Open alerts page.");
        click(alertLocator);
        return new JavaScriptAlertPage(driver,log);
    }

    public WindowPage openMultipleWindowPage(){
        log.info("Open Multiple Window Page");
        click(newWindowLocator);
        return new WindowPage(driver,log);
    }

    public FramePage openFramePage(){
        log.info("Opening iFrame Page...");
        click(iFrameLocator);
        return new  FramePage(driver,log);
    }

    public UploadPage openImageUploadPage(){
        log.info("Starting Image upload page..");
        click(imageUploadLocator);
        return new UploadPage(driver,log);
    }


    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     */
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible
     * on the page
     */
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }


}

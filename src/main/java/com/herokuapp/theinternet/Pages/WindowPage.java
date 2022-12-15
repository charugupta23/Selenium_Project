package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage extends BasePageObject{

    private By multipleWindowLocator = By.linkText("Multiple Windows");
    private By openNewWindow = By.linkText("Click Here");
    public WindowPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public WindowPage openMultipleWindowLink(){
        click(multipleWindowLocator);
        return new WindowPage(driver,log);
    }

    public NewWindowPage openNewWindow(){
        click(openNewWindow);
        return new NewWindowPage(driver,log);
    }

    public NewWindowPage switchToNewWindow(){
        switchToWindowWithTitle ("New Window");
        return new NewWindowPage(driver,log);
    }

}

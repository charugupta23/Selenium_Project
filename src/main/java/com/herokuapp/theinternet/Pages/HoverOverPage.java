package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoverOverPage extends BasePageObject{
    private String pageUrl = "https://the-internet.herokuapp.com/hovers";

    private By avatarLocator = By.xpath("//div[@class = 'figure']");
    private By viewProfileLinkLocator = By.xpath(".//a[contains(text(),'View profile')]");

    public HoverOverPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage(){
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    public void openUserLinkProfile(int i){
        WebElement locator = driver.findElement(By.xpath("/html/body/div[2]"));
        List<WebElement> avatar = locator
                .findElements(By.xpath("//div[@class = 'figure']"));
        WebElement specifiedUser = avatar.get(i-1);
        hoverOverElement(specifiedUser);
        specifiedUser.findElement(viewProfileLinkLocator).click();

    }
}

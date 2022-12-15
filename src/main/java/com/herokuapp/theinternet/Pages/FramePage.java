package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends BasePageObject{

    private By editorLocator = By.id("tinymce");
    private By frame = By.tagName("iframe");
    public FramePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getEditorText(){
        switchToFrame(frame);
        String text = find(editorLocator).getText();
        log.info("Text is  :"+ text);
        return text;
    }
}

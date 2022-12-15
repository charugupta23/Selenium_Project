package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage extends BasePageObject{

    private String pageUrl="https://the-internet.herokuapp.com/upload";
    private By chooseFileFieldLocator = By.id("file-upload");
    private By uploadButtonLocator = By.id("file-submit");
    private By uploadedFilesLocator = By.id("uploaded-files");

    public UploadPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage(){
        log.info("opening page : "+ pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    public void pushUploadButton(){
        log.info("Click on upload button");
        click(uploadButtonLocator);
    }

    public void selectFile(String fileName){
        String filePath = System.getProperty("user.dir")
                +"/src/main/resources/files/"
                +fileName;
        type(filePath, chooseFileFieldLocator);
        log.info("file is selected");
    }

    public String getUplaodedFileName(){
        String names = find(uploadedFilesLocator).getText();
        log.info("Uploaded Files : "+names);
        return names;
    }
}
package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderPage extends BasePageObject{
    private String pageUrl = "https://the-internet.herokuapp.com/horizontal_slider";

    private By rangeLocator = By.id("range");
    private By sliderLocator = By.tagName("input");

    public SliderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage(){
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    public void setSliderTo(String value){
        log.info("Moving slider to : "+ value);

        int width = find(sliderLocator).getSize().getWidth();
        double percent = Double.parseDouble(value)/5;
        int xOffSet = (int)(width*percent);

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(find(sliderLocator), xOffSet,0).build().perform();

        int steps = (int)(Double.parseDouble(value)/0.5);
        pressKey(sliderLocator, Keys.ENTER);
        for (int i=0;i<steps;i++){
            pressKey(sliderLocator,Keys.ARROW_RIGHT);
        }
    }
}

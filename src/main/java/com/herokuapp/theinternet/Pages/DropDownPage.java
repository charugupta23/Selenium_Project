package com.herokuapp.theinternet.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownPage extends BasePageObject{
    public DropDownPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    private By dropdownLocator = By.xpath("//*[@id=\"dropdown\"]");

    public void selectOption(){
        log.info("selecting the option");
        List<WebElement> dropDownList = findAll(dropdownLocator);
    }

    public void selectOption(int i){
        log.info("selecting option "+ i +"from dropdown");
        WebElement dropdownElement = find(dropdownLocator);
        Select dropdown = new Select(dropdownElement);
        //waitForVisibilityOf(dropdownLocator,5);
        //dropdownElement.click();
        dropdown.selectByIndex(2);
    }

    public String getSelectedOption(){
        WebElement dropdownElement = find(dropdownLocator);
        Select dropdown = new Select(dropdownElement);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        log.info(selectedOption + "selected option in dropdown");
        return selectedOption;
    }
}

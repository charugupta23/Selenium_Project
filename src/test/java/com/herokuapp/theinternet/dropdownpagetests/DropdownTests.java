package com.herokuapp.theinternet.dropdownpagetests;

import com.herokuapp.theinternet.Pages.DropDownPage;
import com.herokuapp.theinternet.Pages.WelcomePage;
import com.herokuapp.theinternet.base.BaseTest.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {

    @Test
    public void dropdownTest(){
        log.info("strating dropdown test");
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        DropDownPage dropDownPage = welcomePage.openDropdownPage();

        dropDownPage.selectOption(2);

        String selectedOption = dropDownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "option 2 is selected. instead selected - "+selectedOption);

    }
}

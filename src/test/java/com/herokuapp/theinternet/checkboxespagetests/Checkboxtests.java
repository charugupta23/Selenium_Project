package com.herokuapp.theinternet.checkboxespagetests;

import com.herokuapp.theinternet.Pages.CheckboxPage;
import com.herokuapp.theinternet.Pages.WelcomePage;
import com.herokuapp.theinternet.base.BaseTest.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxtests extends TestUtilities {
    @Test
    public void selectingTwoCheckboxesTest(){
        log.info("starting selecting two checkboxes test.");

        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        CheckboxPage checkboxPage = welcomePage.openTwoCheckboxesPage();

        //select all checkboxes
        checkboxPage.selectAllCheckboxes();

        //verify all checkboxes are selected
        Assert.assertTrue(checkboxPage.areAllCheckboxesChecked(),
                "not all checkboxes are selected!");

    }
}

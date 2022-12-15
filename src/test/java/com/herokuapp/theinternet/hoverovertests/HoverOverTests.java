package com.herokuapp.theinternet.hoverovertests;

import com.herokuapp.theinternet.Pages.HoverOverPage;
import com.herokuapp.theinternet.base.BaseTest.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverOverTests extends TestUtilities {
    @Test
    public void hoverOverTest(){
        log.info("Startimg HoverOver Test..");

        HoverOverPage hoverOverPage = new HoverOverPage(driver,log);
        hoverOverPage.openPage();
        sleep(5000);
        hoverOverPage.openUserLinkProfile(2);
        Assert.assertTrue(hoverOverPage.getCurrentUrl().contains("/users/2"),
                "Url of opened page is not expected User 1 page url");

    }
}

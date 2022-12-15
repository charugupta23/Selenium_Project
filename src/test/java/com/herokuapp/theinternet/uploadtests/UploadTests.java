package com.herokuapp.theinternet.uploadtests;

import com.herokuapp.theinternet.Pages.UploadPage;
import com.herokuapp.theinternet.base.BaseTest.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

    @Test
    public void imageUploadTest(){
        UploadPage uploadPage = new UploadPage(driver,log);
        uploadPage.openPage();

        String fileName = "logo.png";
        uploadPage.selectFile("logo.png");

        uploadPage.pushUploadButton();

        String fileNames = uploadPage.getUplaodedFileName();

        Assert.assertEquals(fileName,fileNames);
    }
}

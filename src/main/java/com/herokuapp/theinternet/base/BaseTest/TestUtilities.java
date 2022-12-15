package com.herokuapp.theinternet.base.BaseTest;

public class TestUtilities extends BaseTest{
    protected void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

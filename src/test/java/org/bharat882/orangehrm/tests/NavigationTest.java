package org.bharat882.orangehrm.tests;

import org.bharat882.orangehrm.base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NavigationTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        startDriver();
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void canOpenOrangeHrmLogin(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("OrangeHRM")), "Expected page title to contain 'OrangeHRM'");
    }
}

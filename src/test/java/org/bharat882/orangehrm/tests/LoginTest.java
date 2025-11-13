package org.bharat882.orangehrm.tests;

import org.bharat882.orangehrm.base.BaseTest;
import org.bharat882.orangehrm.pages.DashboardPage;
import org.bharat882.orangehrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})
public class LoginTest extends BaseTest {


    @BeforeMethod
    public void SetUp(){
        startDriver();
    }

    @AfterTest
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void loginWithValidCredentials_navigatesToDashboard(){
        LoginPage login = new LoginPage(driver, wait).open();
        login.typeUsername("Admin");
        login.typePassword("admin123");
        login.submit();

        DashboardPage dashboard = new DashboardPage(driver, wait);
        Assert.assertTrue(dashboard.isAt(), "Expected to be at Dashboard after valid login");
    }




}

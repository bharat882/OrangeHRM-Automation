package org.bharat882.orangehrm.tests;


import io.qameta.allure.testng.AllureTestNg;
import net.bytebuddy.asm.Advice;
import org.bharat882.orangehrm.base.BaseTest;
import org.bharat882.orangehrm.pages.ApplyLeavePage;
import org.bharat882.orangehrm.pages.LeaveMenu;
import org.bharat882.orangehrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDate;

@Listeners({AllureTestNg.class})
public class ApplyLeaveTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        startDriver();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        quitDriver();
    }

    @DataProvider(name = "leaveTypes")
    public Object[][] leaveTypes(){
        return new Object[][]{
                {"CAN - Bereavement", 11},
                {"CAN - Personal",12},
                {"CAN - Vacation",13}
        };
    }

    @Test(dataProvider = "leaveTypes", enabled = false)
    public void canApplyLeave_withSuccessToast(String leaveType, int offSet){
        LoginPage login = new LoginPage(driver, wait);
        login.open();
        login.typeUsername("DotDot");
        login.typePassword("admin123");
        login.submit();

        LeaveMenu menu = new LeaveMenu(driver, wait);
        menu.openApply();

        LocalDate tomorrow = LocalDate.now().plusDays(offSet);

        ApplyLeavePage apply = new ApplyLeavePage(driver, wait);
        apply.selectLeaveType(leaveType)
                .setDates(tomorrow,tomorrow)
                .setComment("Automated request for "+leaveType)
                .submit();

        Assert.assertTrue(apply.wasSuccess(),"Expected a success toast after applying leave for: " + leaveType);
    }
}

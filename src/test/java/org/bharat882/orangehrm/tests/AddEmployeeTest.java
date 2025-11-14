package org.bharat882.orangehrm.tests;

import io.qameta.allure.testng.AllureTestNg;
import org.bharat882.orangehrm.base.BaseTest;
import org.bharat882.orangehrm.pages.AddEmployeePage;
import org.bharat882.orangehrm.pages.EmployeePersonalDetailsPage;
import org.bharat882.orangehrm.pages.LoginPage;
import org.bharat882.orangehrm.pages.PIMMenu;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({AllureTestNg.class})
public class AddEmployeeTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        startDriver();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        quitDriver();
    }

    @DataProvider(name="employeeData")
    public Object[][] employeeData(){
        return new Object[][]{
                {"Aarav", "K.", "Sharma"},
                {"Maya",  "R.", "Patel"},
                {"Dev",   "",   "Singh"}
        };
    }

    @Test(dataProvider= "employeeData")
    public void canAddEmployee(String first, String middle, String last){
        LoginPage login = new LoginPage(driver, wait);
        login.open();
        login.typeUsername("Admin");
        login.typePassword("admin123");
        login.submit();

        PIMMenu menu = new PIMMenu(driver, wait);
        menu.openAddEmployee();

        AddEmployeePage add = new AddEmployeePage(driver, wait);
        add.typeFirstName(first);
        add.typeMiddleName(middle);
        add.typeLastName(last);
        add.save();


    }
}

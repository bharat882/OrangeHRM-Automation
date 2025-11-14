package org.bharat882.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePersonalDetailsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;


    public EmployeePersonalDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private final By header = By.cssSelector("h6");

    public boolean isAt(){

        wait.until(ExpectedConditions.urlContains("/pim/viewPersonalDetails/"));
      //  String text = wait.until(ExpectedConditions.visibilityOfElementLocated(header)).getText();

        return driver.getCurrentUrl().contains("/pim/viewPersonalDetails/");

    }
}

package org.bharat882.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMMenu {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pimMenu = By.xpath("//span[normalize-space()='PIM']");
    private final By addEmployee = By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and normalize-space()='Add Employee']");

    private final By header = By.cssSelector("h6");


    public PIMMenu(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openPIM(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimMenu)).click();
    }

    public void openAddEmployee(){
        openPIM();
        wait.until(ExpectedConditions.elementToBeClickable(addEmployee)).click();

        wait.until(ExpectedConditions.urlContains("/pim/addEmployee"));
    }
}

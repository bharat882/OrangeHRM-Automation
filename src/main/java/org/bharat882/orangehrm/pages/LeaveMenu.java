package org.bharat882.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeaveMenu {

    private final WebDriver driver;
    private final WebDriverWait wait;


    public LeaveMenu(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private final By leaveMenu = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
    private final By applyLink = By.xpath("//a[normalize-space()='Apply']");

    public void openApply(){
        wait.until(ExpectedConditions.elementToBeClickable(leaveMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(applyLink)).click();
        wait.until(ExpectedConditions.urlContains("/leave/applyLeave"));
    }
}



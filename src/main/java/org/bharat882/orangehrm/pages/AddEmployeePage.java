package org.bharat882.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstName = By.name("firstName");
    private final By middleName = By.name("middleName");
    private final By lastName = By.name("lastName");
    private final By saveButton = By.cssSelector("button[type='submit']");


    public AddEmployeePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
    }

    public AddEmployeePage typeFirstName(String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).clear();
        driver.findElement(firstName).sendKeys(value);
        return this;
    }

    public AddEmployeePage typeMiddleName(String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(middleName)).clear();
        driver.findElement(middleName).sendKeys(value);
        return this;
    }

    public AddEmployeePage typeLastName(String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).clear();
        driver.findElement(lastName).sendKeys(value);
        return this;
    }

    public void save(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}

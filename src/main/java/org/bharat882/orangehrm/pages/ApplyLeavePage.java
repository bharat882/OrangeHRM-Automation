package org.bharat882.orangehrm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ApplyLeavePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By leaveTypeDropdown = By.cssSelector(".oxd-select-text-input");
    // Explicit From/To inputs for dd-mm-yyyy placeholder
    private final By fromDateInput = By.xpath("(//input[@placeholder='dd-mm-yyyy'])[1]");
    private final By toDateInput   = By.xpath("(//input[@placeholder='dd-mm-yyyy'])[2]");
    private final By commentArea   = By.cssSelector("textarea.oxd-textarea");
    private final By applyBtn      = By.cssSelector("button[type='submit']");
    private final By successToast  = By.cssSelector(".oxd-toast.oxd-toast--success");

    // Correct pattern: MM = months
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ApplyLeavePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        // Page readiness
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaveTypeDropdown));
    }

    public ApplyLeavePage selectLeaveType(String visibleText) {
        wait.until(ExpectedConditions.elementToBeClickable(leaveTypeDropdown)).click();
        By option = By.xpath("//div[@role='listbox']//span[normalize-space()='" + visibleText + "']");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
        return this;
    }

    public ApplyLeavePage setDates(LocalDate from, LocalDate to) {
        WebElement fromEl = wait.until(ExpectedConditions.elementToBeClickable(fromDateInput));
        WebElement toEl   = wait.until(ExpectedConditions.elementToBeClickable(toDateInput));

        String fromStr = fmt.format(from);
        String toStr   = fmt.format(to);

        typeDate(fromEl, fromStr);
        // Verify value stuck
        wait.until(ExpectedConditions.attributeToBe(fromDateInput, "value", fromStr));

        typeDate(toEl, toStr);
        wait.until(ExpectedConditions.attributeToBe(toDateInput, "value", toStr));

        return this;
    }

    private void typeDate(WebElement el, String value) {
        try {
            el.click();
            el.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, value, Keys.TAB);
        } catch (InvalidElementStateException e) {
            // Minimal JS fallback if typing fails
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value = arguments[1];" +
                            "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));" +
                            "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                    el, value
            );
        }
    }

    public ApplyLeavePage setComment(String comment) {
        WebElement area = wait.until(ExpectedConditions.visibilityOfElementLocated(commentArea));
        area.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, comment);
        return this;
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(applyBtn)).click();
    }

    public boolean wasSuccess() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}

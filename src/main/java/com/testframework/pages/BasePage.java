package com.testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public BasePage click(By locator) {
        logger.debug("Clicking element: {}", locator);
        waitForElementToBeClickable(locator).click();
        return this;
    }

    public BasePage rightClick(By locator) {
        logger.debug("Right-clicking element: {}", locator);
        WebElement element = waitForElementToBeClickable(locator);
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        return this;
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }


    protected void type(By locator, String text) {
        logger.debug("Typing '{}' into element: {}", text, locator);
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        logger.debug("Getting text from element: {}", locator);
        return waitForElementToBeVisible(locator).getText();
    }

    public boolean isElementDisplayed(By locator) {
            if (waitForElementToBeVisible(locator).isDisplayed()){
                logger.info("Element {} is displayed", locator);
                return true;
            } else {
                logger.info("Element {} is not displayed", locator);
                return false;
            }
    }

    public boolean isElementClickable(By locator) {
        if (waitForElementToBeClickable(locator).isEnabled()){
            logger.info("Element {} is clickable", locator);
            return true;
        } else {
            logger.info("Element {} is not clickable", locator);
            return false;
        }
    }

    public boolean isImageBroken(WebElement imageElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return arguments[0].naturalWidth === 0 || arguments[0].naturalHeight === 0;", imageElement);
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isChecked(By locator) {
        logger.debug("Checking if checkbox is selected: {}", locator);
        WebElement element = waitForElementToBeVisible(locator);
        return element.isSelected();
    }

    public boolean isNotChecked(By locator) {
        logger.debug("Checking if checkbox is not selected: {}", locator);
        WebElement element = waitForElementToBeVisible(locator);
        return !element.isSelected();
    }
}

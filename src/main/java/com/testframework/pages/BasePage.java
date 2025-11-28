package com.testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    protected void click(By locator) {
        logger.debug("Clicking element: {}", locator);
        waitForElementToBeClickable(locator).click();
    }

    protected void type(By locator, String text) {
        logger.debug("Typing '{}' into element: {}", text, locator);
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        logger.debug("Getting text from element: {}", locator);
        return waitForElementToBeVisible(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return waitForElementToBeVisible(locator).isDisplayed();
        } catch (Exception e) {
            logger.debug("Element not displayed: {}", locator);
            return false;
        }
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForUrl(String urlPart) {
        logger.debug("Waiting for URL to contain: {}", urlPart);
        wait.until(ExpectedConditions.urlContains(urlPart));
    }
}

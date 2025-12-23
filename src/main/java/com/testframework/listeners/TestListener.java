package com.testframework.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.testframework.core.DriverManager;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Starting test: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test PASSED: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test FAILED: {}", result.getMethod().getMethodName());
        logger.error("Failure reason: {}", result.getThrowable().getMessage());
        
        // Capture screenshot on failure
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            saveScreenshot(driver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test SKIPPED: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("///////////////////////////////////////////");
        logger.info("Starting test suite: {}", context.getName());
        logger.info("///////////////////////////////////////////");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("///////////////////////////////////////////");
        logger.info("Finished test suite: {}", context.getName());
        logger.info("Tests passed: {}", context.getPassedTests().size());
        logger.info("Tests failed: {}", context.getFailedTests().size());
        logger.info("Tests skipped: {}", context.getSkippedTests().size());
        logger.info("///////////////////////////////////////////");
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        logger.info("Capturing screenshot...");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

package com.testframework.core;

import com.testframework.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        logger.info("=== Starting test setup ===");
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getInternetUrl());
        logger.info("Navigated to: {}", ConfigReader.getInternetUrl());
    }

    @AfterMethod
    public void tearDown() {
        logger.info("=== Test completed, closing browser ===");
        DriverManager.quitDriver();
    }
}

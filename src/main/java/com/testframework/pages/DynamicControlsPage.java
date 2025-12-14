package com.testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage extends BasePage{
    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }
    public static final By checkbox = By.xpath("//input[@type = 'checkbox']");
    public static final By removeCheckboxButton = By.xpath("//button[@onclick='swapCheckbox()']");

    public static final By inputField = By.xpath("//input[@type = 'text']");
    public static final By disableButton = By.xpath("//button[@type = 'button'and @onclick='swapInput()'] ");

    @Override
    public boolean isNotSelected(By locator) {
        return super.isNotSelected(locator);
    }

    @Override
    public boolean isSelected(By locator) {
        return super.isSelected(locator);
    }

    @Override
    public boolean isChecked(By locator) {
        return super.isChecked(locator);
    }

    @Override
    public boolean isNotChecked(By locator) {
        return super.isNotChecked(locator);
    }

    @Override
    public boolean isElementClickable(By locator) {
        return super.isElementClickable(locator);
    }

}

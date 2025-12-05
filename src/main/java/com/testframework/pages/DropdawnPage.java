package com.testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdawnPage extends BasePage{

    public DropdawnPage(WebDriver driver) {
        super(driver);
    }

    public static final By DROPDOWN = By.id("dropdown");
    public static final By option1 = By.xpath("//option[contains(text(),'Option 1')]");
    public static final By option2 = By.xpath("//option[contains(text(),'Option 2')]");



}

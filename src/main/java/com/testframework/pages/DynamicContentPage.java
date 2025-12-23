package com.testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicContentPage extends BasePage{


    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    private static final By dynamicContentDiv = By.xpath("//div[@class='large-10 columns']");


    public static List<WebElement> dynamicContent = driver.findElements(dynamicContentDiv);

    public List<WebElement> getDynamicContent() {
        return driver.findElements(dynamicContentDiv);
    }


    public static By getDynamicContentDiv() {
        return dynamicContentDiv;
    }

}

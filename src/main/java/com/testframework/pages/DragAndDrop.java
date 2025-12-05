package com.testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDrop extends BasePage{


    public DragAndDrop(WebDriver driver) {
        super(driver);
    }

    public static final By aBox = By.xpath("//*[@id='column-a']");
    public static final By bBox = By.xpath("//*[@id='column-b']");
    public static final By headerA = By.cssSelector("#column-a header");
    public static final By headerB = By.cssSelector("#column-b header");

    public void dragAndDrop() {
       dragAndDrop(aBox, bBox);
    }
}

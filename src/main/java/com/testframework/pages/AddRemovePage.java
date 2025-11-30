package com.testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddRemovePage extends InternetCommonPage{
    public AddRemovePage(WebDriver driver) {
        super(driver);
    }
    public static final By addElementButton= By.xpath("//button[contains(@onclick, 'add')]");

    public static final By deleteButtons = By.xpath("//button[text()='Delete']");



    public void clickAddElement(){
        if(isElementDisplayed(addElementButton)){
                click(addElementButton);
                logger.debug("click add element");
            }  else  logger.debug("Element is not enabled");
        }
    public int getDeleteButtonsCount() {
        return driver.findElements(deleteButtons).size();
    }

    public void clickDeleteButton(){
        if(isElementDisplayed(deleteButtons)){
            click(deleteButtons);
        }
    }

    public void deleteAllDeleteButtons(){
        for ( WebElement webElement : driver.findElements(deleteButtons)) {
            click(deleteButtons);
        }
        logger.info("all 'delete' buttons deleted");
    }

    }




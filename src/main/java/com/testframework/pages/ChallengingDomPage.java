package com.testframework.pages;

import org.apache.hc.client5.http.utils.ByteArrayBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ChallengingDomPage extends InternetCommonPage{
    public ChallengingDomPage(WebDriver driver) {
        super(driver);
    }

    public static final By buttonBlue = By.className("button");
    public static final By buttonRed = By.className("alert");
    public static final By buttonGreen = By.className("success");

    public String getButtonText(By locator) {
        return driver.findElement(locator).getText();
    }


    public void clickButton(By locator) {
        driver.findElement(locator).click();
    }


        public List<List<String>> getTableData() {
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

        List<List<String>> tableData = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            List<String> rowData = new ArrayList<>();
            for (WebElement cell : cells) {
                rowData.add(cell.getText());
            }

            tableData.add(rowData);
        }

        return tableData;
    }



}

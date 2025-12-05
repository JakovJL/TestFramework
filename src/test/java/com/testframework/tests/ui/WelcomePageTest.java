package com.testframework.tests.ui;

import com.testframework.core.BaseTest;
import com.testframework.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.testframework.pages.InternetCommonPage.*;

public class WelcomePageTest extends BaseTest {

    private InternetCommonPage internetCommonPage;

    @BeforeMethod
    public void beforeMethod() {
        internetCommonPage= new InternetCommonPage(driver);
    }

    @Test
    public void welcomePageHeaderTest() {

        String headerText = internetCommonPage.getHeaderText();
        Assert.assertEquals(headerText, "Welcome to the-internet", "Header text should match");
        Assert.assertEquals("https://the-internet.herokuapp.com/",driver.getCurrentUrl(),"not on https://the-internet.herokuapp.com/");
    }

    @Test
    public void navigationToAbTesting() {
        internetCommonPage.clickABTesting();
        Assert.assertTrue(driver.getCurrentUrl().contains("/abtest"), "Should navigate to A/B Testing page");
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'split testing')]")).getText(),
                "Also known as split testing. This is a way in which businesses are able to simultaneously test and" +
                        " learn different versions of a page to see which text and/or functionality works best towards a desired " +
                        "outcome (e.g. a user action such as a click-through).","wrong message");
    }

    @Test
    public void addRemoveElementsTest() {
        internetCommonPage.clickAddRemoveElement();
        AddRemovePage addRemovePage= new AddRemovePage(driver);
        addRemovePage.clickAddElement();
        addRemovePage.clickAddElement();
        addRemovePage.clickAddElement();
        addRemovePage.clickAddElement();
        Assert.assertEquals(addRemovePage.getDeleteButtonsCount(),4, "no such matches");
        addRemovePage.clickDeleteButton();
        Assert.assertEquals(addRemovePage.getDeleteButtonsCount(),3, "no such matches");
        addRemovePage.deleteAllDeleteButtons();
        Assert.assertEquals(addRemovePage.getDeleteButtonsCount(),0, "no such matches");
    }

    @Test
    public void basicAuthenticationTest() throws InterruptedException {
        internetCommonPage.clickBasicAuth();
        String username = "admin";
        String password = "admin";
        String authUrl = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        driver.get(authUrl);
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText()
                ,"Congratulations! You must have the proper credentials.","no such matches");
        Thread.sleep(5000);
    }

    @Test
    public void brokenImageVerificationTest() throws InterruptedException {
        internetCommonPage.click(InternetCommonPage.BROKEN_IMAGES);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Broken Images", "no such matches");

        List<WebElement> images = driver.findElements(By.xpath("//img"));
        int brokenCount = 0;
        for (WebElement img : images) {
            if (internetCommonPage.isImageBroken(img)) {
                brokenCount++;
                logger.info("Broken image found: " + img.getAttribute("src"));
            }
        }
        Assert.assertTrue(brokenCount ==2, "No broken images found, but expected some");
    }

    @Test
    public void challengingDomTest() throws InterruptedException {
        internetCommonPage.click(InternetCommonPage.CHALLENGING_DOM);
        ChallengingDomPage challengingDomPage= new ChallengingDomPage(driver);
        Assert.assertTrue(challengingDomPage.isElementDisplayed(ChallengingDomPage.buttonBlue),"no blue button");
        Assert.assertTrue(challengingDomPage.isElementDisplayed(ChallengingDomPage.buttonGreen),"no green button");
        Assert.assertTrue(challengingDomPage.isElementDisplayed(ChallengingDomPage.buttonRed),"no red button");
        Assert.assertTrue(challengingDomPage.isElementClickable(ChallengingDomPage.buttonBlue),"blue button is not clickable");
        Assert.assertTrue(challengingDomPage.isElementClickable(ChallengingDomPage.buttonGreen),"green button is not clickable");
        Assert.assertTrue(challengingDomPage.isElementClickable(ChallengingDomPage.buttonRed),"red not clickable");
        List<List<String>> tableData = challengingDomPage.getTableData();

        Assert.assertTrue(tableData.size()==10,"unexpected number of table data");
        List<String> firstRow = tableData.get(0);
        Assert.assertEquals(firstRow.get(1),"Apeirian0");
        List<String> secRow = tableData.get(1);
        Assert.assertEquals(secRow.get(1),"Apeirian1");
    }

    @Test
    public void checkboxTest() throws InterruptedException {
        internetCommonPage.click(CHECKBOXES);
        String checkbox1 ="//input[@type='checkbox'][1]";
        String checkbox2 ="//input[@type='checkbox'][2]";
        Assert.assertTrue(internetCommonPage.isNotChecked(By.xpath(checkbox1)),"checkbox is selected");
        internetCommonPage.click(By.xpath(checkbox1));
        Assert.assertTrue(internetCommonPage.isChecked(By.xpath(checkbox1)),"checkbox is not selected");
        internetCommonPage.click(By.xpath(checkbox2));
        Assert.assertTrue(internetCommonPage.isNotChecked(By.xpath(checkbox2)),"checkbox is selected");
    }

    @Test
    public void jsAlertTest() throws InterruptedException {
        internetCommonPage.click(CONTEXT_MENU);
        String hotSpot = "//div[@id='hot-spot']";

        Assert.assertEquals(internetCommonPage.rightClick(By.xpath(hotSpot)).getAlertText(),
                "You selected a context menu","wrong alert text");

        internetCommonPage.acceptAlert();
        Assert.assertEquals(internetCommonPage.getText(By.xpath("//p[text()='Context menu items are custom" +
                " additions that appear in the right-click menu.']")),"Context menu items are custom additions that appear in the right-click menu.");

        Thread.sleep(2000);
    }

    @Test
    public void disappearingElementsTest(){
        internetCommonPage.click(DISAPPEARING_ELEMENTS);
        List<WebElement> buttons= driver.findElements(By.xpath("//ul/li"));

        Assert.assertEquals(buttons.size(),5,"Button count less then 5");
        List<String> expectedTexts = Arrays.asList("Home", "About", "Contact Us", "Portfolio", "Gallery");
        List<String> actualTexts = buttons.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        Assert.assertTrue(actualTexts.containsAll(expectedTexts),
                "not all buttons presence: " + actualTexts);
    }

    @Test
    public void  dragAndDropTest() throws InterruptedException {
        internetCommonPage.click(DRAG_AND_DROP);
        DragAndDrop dragAndDrop = new DragAndDrop(driver);
        Assert.assertEquals(driver.findElement(DragAndDrop.headerA).getText(),"A");
        Assert.assertEquals(driver.findElement(DragAndDrop.headerB).getText(),"B");
        dragAndDrop.dragAndDrop();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(DragAndDrop.headerA).getText(),"B");
        Assert.assertEquals(driver.findElement(DragAndDrop.headerB).getText(),"A");
    }

    @Test
    public void dropDawnTest() throws InterruptedException {
        internetCommonPage.click(DROPDOWN);
        DropdawnPage dropdawnPage = new DropdawnPage(driver);
        dropdawnPage.click(DropdawnPage.DROPDOWN).click(DropdawnPage.option2);
        Assert.assertTrue(dropdawnPage.isSelected(DropdawnPage.option2),"drop down is not selected");
    }


}

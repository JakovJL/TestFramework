package com.testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InternetCommonPage extends BasePage{

    public static final By HEADER = By.xpath("//h1[text()='Welcome to the-internet']");
    public static final By AB_TESTING = By.xpath("//ul/li/a[text()='A/B Testing']");
    public static final By ADD_REMOVE_ELEMENTS = By.xpath("//ul/li/a[text()='Add/Remove Elements']");
    public static final By BASIC_AUTH = By.xpath("//ul/li/a[text()='Basic Auth']");
    public static final By BROKEN_IMAGES = By.xpath("//ul/li/a[text()='Broken Images']");
    public static final By CHALLENGING_DOM = By.xpath("//ul/li/a[text()='Challenging DOM']");
    public static final By CHECKBOXES = By.xpath("//ul/li/a[text()='Checkboxes']");
    public static final By CONTEXT_MENU = By.xpath("//ul/li/a[text()='Context Menu']");
    public static final By DIGEST_AUTH = By.xpath("//ul/li/a[text()='Digest Authentication']");
    public static final By DISAPPEARING_ELEMENTS = By.xpath("//ul/li/a[text()='Disappearing Elements']");
    public static final By DRAG_AND_DROP = By.xpath("//ul/li/a[text()='Drag and Drop']");
    public static final By DROPDOWN = By.xpath("//ul/li/a[text()='Dropdown']");
    public static final By DYNAMIC_CONTENT = By.xpath("//ul/li/a[text()='Dynamic Content']");
    public static final By DYNAMIC_CONTROLS = By.xpath("//ul/li/a[text()='Dynamic Controls']");
    public static final By DYNAMIC_LOADING = By.xpath("//ul/li/a[text()='Dynamic Loading']");
    public static final By ENTRY_AD = By.xpath("//ul/li/a[text()='Entry Ad']");
    public static final By EXIT_INTENT = By.xpath("//ul/li/a[text()='Exit Intent']");
    public static final By FILE_DOWNLOAD = By.xpath("//ul/li/a[text()='File Download']");
    public static final By FILE_UPLOAD = By.xpath("//ul/li/a[text()='File Upload']");
    public static final By FLOATING_MENU = By.xpath("//ul/li/a[text()='Floating Menu']");
    public static final By FORGOT_PASSWORD = By.xpath("//ul/li/a[text()='Forgot Password']");
    public static final By FORM_AUTHENTICATION = By.xpath("//ul/li/a[text()='Form Authentication']");
    public static final By FRAMES = By.xpath("//ul/li/a[text()='Frames']");
    public static final By GEOLOCATION = By.xpath("//ul/li/a[text()='Geolocation']");
    public static final By HORIZONTAL_SLIDER = By.xpath("//ul/li/a[text()='Horizontal Slider']");
    public static final By HOVERS = By.xpath("//ul/li/a[text()='Hovers']");
    public static final By INFINITE_SCROLL = By.xpath("//ul/li/a[text()='Infinite Scroll']");
    public static final By INPUTS = By.xpath("//ul/li/a[text()='Inputs']");
    public static final By JQUERY_UI_MENUS = By.xpath("//ul/li/a[text()='JQuery UI Menus']");
    public static final By JAVASCRIPT_ALERTS = By.xpath("//ul/li/a[text()='JavaScript Alerts']");
    public static final By JAVASCRIPT_ERROR = By.xpath("//ul/li/a[text()='JavaScript onload event error']");
    public static final By KEY_PRESSES = By.xpath("//ul/li/a[text()='Key Presses']");
    public static final By LARGE_DOM = By.xpath("//ul/li/a[text()='Large & Deep DOM']");
    public static final By MULTIPLE_WINDOWS = By.xpath("//ul/li/a[text()='Multiple Windows']");
    public static final By NESTED_FRAMES = By.xpath("//ul/li/a[text()='Nested Frames']");
    public static final By NOTIFICATION_MESSAGES = By.xpath("//ul/li/a[text()='Notification Messages']");
    public static final By REDIRECT_LINK = By.xpath("//ul/li/a[text()='Redirect Link']");
    public static final By SECURE_FILE_DOWNLOAD = By.xpath("//ul/li/a[text()='Secure File Download']");
    public static final By SHADOW_DOM = By.xpath("//ul/li/a[text()='Shadow DOM']");
    public static final By SHIFTING_CONTENT = By.xpath("//ul/li/a[text()='Shifting Content']");
    public static final By SLOW_RESOURCES = By.xpath("//ul/li/a[text()='Slow Resources']");
    public static final By SORTABLE_DATA_TABLES = By.xpath("//ul/li/a[text()='Sortable Data Tables']");
    public static final By STATUS_CODES = By.xpath("//ul/li/a[text()='Status Codes']");
    public static final By TYPOS = By.xpath("//ul/li/a[text()='Typos']");
    public static final By WYSIWYG_EDITOR = By.xpath("//ul/li/a[text()='WYSIWYG Editor']");

    public InternetCommonPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText(){
        return getText(HEADER);
    }
    public void clickABTesting(){
        click(AB_TESTING);
        logger.info("Click on ab testing page");
    }

    public InternetCommonPage clickAddRemoveElement(){
        click(ADD_REMOVE_ELEMENTS);
        logger.info("Click on Add Remove element page");
        return this;
    }

    public InternetCommonPage clickBasicAuth(){
        click(BASIC_AUTH);
        logger.info("Click on basic auth page");
        return this;
    }






}


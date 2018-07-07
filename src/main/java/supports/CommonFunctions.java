package supports;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class CommonFunctions {
    /**
     * Selenium owner methods
     * 1. launchBrowser : WebDriver
     * 2. getElement: WebElement
     * 3. getBy: By
     * 4. visit : void
     * 5. click : void
     * 6. fillIn : void
     * 7. getText: String
     * 8. waitForElementPresent: void
     * 9. isDisplayed: bool
     * 10. isEnabled : bool
     * 11. isSelected : bool
     * 12. waitForElementDisappeared
     * 13. select : void
     * 14. takeScreenshot: void
     */

    private static WebDriver driver;
    private static final long TIMEOUT = 60;
    private static WebDriverWait waiter;
    private static final String URL = "https://google.com";
    private static final String BROWSER = "chrome";

    public static WebDriver getDriver() {
        return driver;
    }

    public static void launchBrowser(String browser) {
        if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("chrome")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            System.err.println("Browser " + browser + " is not defined");
        }
        waiter = new WebDriverWait(driver, TIMEOUT);
    }

    public static void launchBrowser() {
        launchBrowser(BROWSER);
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static By getBy(How how, String locator) {
        By element = null;
        switch (how) {
            case CLASS_NAME:
                element = By.className(locator);
                break;
            case CSS:
                element = By.cssSelector(locator);
                break;
            case ID:
                element = By.id(locator);
                break;
            case ID_OR_NAME:
                element = ByIdOrName.id(locator);
                break;
            case LINK_TEXT:
                element = By.linkText(locator);
                break;
            case NAME:
                element = By.name(locator);
                break;
            case PARTIAL_LINK_TEXT:
                element = By.partialLinkText(locator);
                break;
            case TAG_NAME:
                element = By.tagName(locator);
                break;
            case XPATH:
                element = By.xpath(locator);
                break;
            case UNSET:
                break;
        }
        return element;

    }

    public static void visit(String url) {
        driver.get(url);

    }

    public static void visit() {
        visit(URL);
    }


    public static void click(How how, String locator) {
        waitForElementPresent(how, locator);
        getElement(how, locator).click();
    }

    public static void click(By by) {
        waitForElementPresent(by);
        getElement(by).click();
    }

    private static WebElement getElement(How how, String locator) {
        return driver.findElement(getBy(how, locator));
    }

    private static WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public static void fillIn(How how, String locator, String withText) {
        waitForElementPresent(how, locator);
        getElement(how, locator).clear();
        getElement(how, locator).sendKeys(withText);
    }

    public static void fillIn(By by, String withText) {
        waitForElementPresent(by);
        getElement(by).clear();
        getElement(by).sendKeys(withText);
    }

    public static String getText(How how, String locator) {
        waitForElementPresent(how, locator);
        return getElement(how, locator).getText();
    }

    public static String getText(By by) {
        waitForElementPresent(by);
        return getElement(by).getText();
    }

    public static void waitForElementPresent(How how, String locator) {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(getBy(how, locator)));
    }

    public static void waitForElementPresent(By by) {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static Boolean isDisplayed(How how, String locator) {
        waitForElementPresent(how, locator);
        return getElement(how, locator).isDisplayed();
    }

    public static Boolean isEnabled(How how, String locator) {
        waitForElementPresent(how, locator);
        return getElement(how, locator).isEnabled();
    }

    public static Boolean isSelected(How how, String locator) {
        waitForElementPresent(how, locator);
        return getElement(how, locator).isSelected();
    }

    public static void handleAlertPopup() {

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(getText(How.ID, "content"));
    }

    public static void takeScreenShot(String filePath) throws Exception {
        File screenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = System.currentTimeMillis() / 1000 + "";
        File destFile = new File("./src/main/java/reports/screenshot/" + filePath + "-" + timeStamp + ".png");
        FileUtils.copyFile(screenFile, destFile);
    }

}

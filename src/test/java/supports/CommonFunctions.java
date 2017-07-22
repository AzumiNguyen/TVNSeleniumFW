package supports;

import configuration.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

/**
 * Created by hado on 2/25/17.
 */
public class CommonFunctions extends TestBase {

    public static WebElement getElement(String how, String locator) {
        WebElement el = null;
        if (how.equalsIgnoreCase("id")) {
            el = driver.findElement(By.id(locator));
        } else if (how.equalsIgnoreCase("name")) {
            el = driver.findElement(By.name(locator));
        } else if (how.equalsIgnoreCase("xpath")) {
            el = driver.findElement(By.xpath(locator));
        } else if (how.equalsIgnoreCase("css")) {
            el = driver.findElement(By.cssSelector(locator));
        } else {
            System.err.print("Wrong input arguments" + how + locator);
        }
        return el;
    }

    public static List<WebElement> getElements(String how, String locator) {
        List<WebElement> el = null;
        if (how.equalsIgnoreCase("id")) {
            el = driver.findElements(By.id(locator));
        } else if (how.equalsIgnoreCase("name")) {
            el = driver.findElements(By.name(locator));
        } else if (how.equalsIgnoreCase("xpath")) {
            el = driver.findElements(By.xpath(locator));
        } else if (how.equalsIgnoreCase("css")) {
            el = driver.findElements(By.cssSelector(locator));
        } else {
            System.err.print("Wrong input arguments" + how + locator);
        }
        return el;
    }

    public static WebElement id(String locator) {
        return getElement("id", locator);
    }

    public static List<WebElement> ids(String locator) {
        return getElements("id", locator);
    }

    public static WebElement name(String locator) {
        return getElement("name", locator);
    }

    public static List<WebElement> names(String locator) {
        return getElements("name", locator);
    }

    public static WebElement text(String locator) {
        return getElement("xpath", String.format(".//*[.='%s']", locator));
    }

    public static WebElement xpathOrCss(String locator) {
        if (locator.contains("//")) {
            return getElement("xpath", locator);
        } else {
            return getElement("css", locator);
        }
    }

    public static void visit(String path) {
        driver.manage().window().maximize();
        driver.get(BASE_URL + path);
    }

    public static void fillIn(String how, String locator, String inputStr) {
        waitForElementPresent(driver, how, locator, TIMEOUT);
        getElement(how, locator).clear();
        getElement(how, locator).sendKeys(inputStr);
    }

    public static WebDriver getBrowser(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            return new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        } else System.err.println("The browser " + browser + " is no defined!!");
        return null;
    }

    public static void clickButton(String how, String locator) {
        waitForElementPresent(driver, how, locator, TIMEOUT);
        getElement(locator, how).click();
    }

    public static void waitForElementPresent(WebDriver driver, String how, String locator, int timeout) {

    }

    public static boolean verifyElementEnabled(String how, String locator) {
        waitForElementPresent(driver, how, locator, TIMEOUT);
        return getElement(how, locator).isEnabled();
    }

    public static boolean verifyElementDisplayed(String how, String locator) {
        waitForElementPresent(driver, how, locator, TIMEOUT);
        return getElement(how, locator).isDisplayed();
    }

    public static boolean verifyElementSelected(String how, String locator) {
        waitForElementPresent(driver, how, locator, TIMEOUT);
        return getElement(how, locator).isSelected();
    }
}

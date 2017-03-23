package supports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by hado on 2/25/17.
 */
public class CommonFunctions {

    public static WebElement getElement(WebDriver driver, String how, String locator) {
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

    public static  void visit(WebDriver driver,String url){
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void fillIn(WebDriver driver, String how, String locator,String inputStr){
        waitForElementPresent(driver,how,locator,60);
        getElement(driver,how,locator).clear();
        getElement(driver,how,locator).sendKeys(inputStr);
    }
    public static WebDriver getBrowser(String browser){
        return new FirefoxDriver();
    }
    public static void clickButton(WebDriver driver, String how, String locator){
        waitForElementPresent(driver,how,locator,60);
        getElement(driver,locator,how).click();
    }

    public static void waitForElementPresent(WebDriver driver, String how, String locator,int timeout){

    }
    public static boolean verifyElementEnabled(WebDriver driver, String how, String locator){
        waitForElementPresent(driver,how,locator,60);
        return getElement(driver,how,locator).isEnabled();
    }
    public static boolean verifyElementDisplayed(WebDriver driver, String how, String locator){
        waitForElementPresent(driver,how,locator,60);
        return getElement(driver,how,locator).isDisplayed();
    }
    public static boolean verifyElementSelected(WebDriver driver, String how, String locator){
        waitForElementPresent(driver,how,locator,60);
        return getElement(driver,how,locator).isSelected();
    }
}

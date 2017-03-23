package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by hado on 3/4/17.
 */
public class BMIPage {
    public WebDriver driver;

    public BMIPage(WebDriver driver){
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,100);
        PageFactory.initElements(factory,this);
    }

    @FindBy(xpath=".//a[.='Metric Units']")
    public WebElement tabMetric;

    @FindBy(id="cage")
    public WebElement txtAge;

    @FindBy(id="csex1") //driver.FindElemt
    public WebElement radMale;

    @FindBy(id="csex2")
    public WebElement radFemale;

    @FindBy(id="cheightmeter")
    public WebElement txHeight;

    @FindBy(id="ckg")
    public WebElement txtweight;

    @FindBy(xpath=".//input[@alt='Calculate']")
    public WebElement btnCalculate;

    @FindBy(css=".bigtext")
    public WebElement lblBmiResult;



}




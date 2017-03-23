package configuration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import supports.CommonFunctions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hado on 3/11/17.
 */
public class TestBase {
    public static WebDriver driver;

    @Parameters({"browserName"})
    @BeforeTest
    public static void init(String browserName){
        driver = CommonFunctions.getBrowser(browserName);
    }

    @Parameters({"url"})
    @BeforeMethod
    public static void setUp(String url){

        CommonFunctions.visit(driver, url);
    }
    @DataProvider(name = "bmidata")
    public Object[][] testData() {
        return new Object[][] {
                new Object[] {"25","female","160","53","BMI = 20.70 kg/m2   (Normal)"},
                new Object[] {"25","male","180","73","BMI = 22.53 kg/m2   (Normal)"},
                new Object[] {"31","female","150","80","BMI = 35.56 kg/m2   (Obese Class II)"},
                new Object[] {"31","male","150","80","BMI = 35.56 kg/m2   (Obese Class II)"}
        };
    }



    @AfterMethod
    public void takeScreenShotIfFailure(ITestResult testResult) throws IOException {
        String screenShotFile;
        Date date = new Date();

        //Create format date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        //Create the file name with date time format then grant to "screenShotFile"
        screenShotFile =System.getProperty("user.dir")+"/src/test/java/reports/images/"+ " TestScreenShot"+dateFormat + ".png";

        if (testResult.getStatus() == ITestResult.FAILURE){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenShotFile));
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

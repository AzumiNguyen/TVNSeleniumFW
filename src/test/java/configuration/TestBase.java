package configuration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import supports.CommonFunctions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by hado on 3/11/17.
 */
public class TestBase {
    public static WebDriver driver;
    public static int TIMEOUT = 60;
    public static String BASE_URL="";
    final static String BROWSER ="firefox";


//    @Parameters({"browserName"})
    @BeforeTest
    public static void init() {
        driver = CommonFunctions.getBrowser(System.getProperty("browser.name"));
    }

    @Parameters({"url"})
    @BeforeMethod
    public static void setUp(String url) {

        CommonFunctions.visit(url);
    }

    @DataProvider(name = "bmidata")
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{"25", "female", "160", "53", "BMI = 20.70 kg/m2   (Normal)"}
        };
    }

    @AfterMethod
    public void takeScreenShotIfFailure(ITestResult testResult) throws IOException {
        String screenShotFile;
        String tc_name = testResult.getMethod().getConstructorOrMethod().getName();
        String dateFormat = new SimpleDateFormat("ddMMyyyy_hhmmss").format(Calendar.getInstance().getTime());
        //Create the file name with date time format then grant to "screenShotFile"
        screenShotFile = System.getProperty("user.dir") + "/src/test/java/reports/images/" + "ScreenShot_" + tc_name + "_" + dateFormat + ".png";

        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenShotFile));
            saveImageAttach(scrFile);
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] saveImageAttach(File imageFile) {
        try {
            return toByteArray(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    private static byte[] toByteArray(File file) throws IOException {
        return Files.readAllBytes(Paths.get(file.getPath()));
    }
}

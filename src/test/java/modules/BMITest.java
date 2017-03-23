package modules;

import configuration.TestBase;
import libraries.BMIFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import supports.CommonFunctions;

import java.util.concurrent.TimeUnit;


/**
 * Created by hado on 3/4/17.
 */
public class BMITest extends TestBase{


    @Test(dataProvider = "bmidata")
    public static void bmi_calculate_test(String age,String gender,String height,String weight,String expectedResult) throws InterruptedException {
        BMIFunctions bmiPage = new BMIFunctions(driver);
        bmiPage.selectMetricTab();
        bmiPage.fillBmiForm(age, gender, height, weight);
        AssertJUnit.assertEquals(expectedResult,bmiPage.getBmiResult());
    }





}

package modules;

import configuration.TestBase;
import libraries.BMIFunctions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


/**
 * Created by hado on 3/4/17.
 */
public class BMITest extends TestBase{

    @Test(dataProvider = "bmidata",description = "Body Mass Index test")
    public static void bmi_calculate_test(String age,String gender,String height,String weight,String expectedResult) throws InterruptedException {
        BMIFunctions bmiPage = new BMIFunctions(driver);
        bmiPage.selectMetricTab();
        bmiPage.fillBmiForm(age, gender, height, weight);
        AssertJUnit.assertEquals(expectedResult,bmiPage.getBmiResult());
    }

    @Test
    public static void TC1(){
        Assert.assertEquals(1,1);
    }

    @Test
    public static void TC3(){
        Assert.assertEquals(true,true);
    }





}

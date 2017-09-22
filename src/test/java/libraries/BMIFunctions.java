package libraries;

import objects.BMIPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by hado on 3/4/17.
 */
public class BMIFunctions extends BMIPage {

    public BMIFunctions(WebDriver driver) {
        super(driver);
    }

    public void selectMetricTab(){
        tabMetric.click();
    }

    public void fillBmiForm(String age,String gender, String height,String weight) throws InterruptedException {
        txtAge.clear();
        txtAge.sendKeys(age);

        if(!gender.equalsIgnoreCase("female")) radMale.click();
        else radFemale.click();

        txHeight.clear();
        txHeight.sendKeys(height);

        txtweight.clear();
        txtweight.sendKeys(weight);



        btnCalculate.click();


        for (int i =1;i<=10;i++){
            System.out.println(((JavascriptExecutor) driver)
                    .executeScript("$.active;"));
            Thread.sleep(1000);
        }

    }

    public String getBmiResult()  {


        return lblBmiResult.getText();
    }
}

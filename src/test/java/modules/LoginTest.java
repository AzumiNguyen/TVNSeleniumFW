package modules;


import configuration.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static supports.CommonFunctions.*;

/**
 * Created by hado on 3/11/17.
 */
public class LoginTest extends TestBase {


    @BeforeTest
    public void setUp() {
        visit("http://demoqa.com/registration");
    }

    @Test
    public void TC1() throws IOException {
        name("first_name").sendKeys("Jony");
        name("first_name").sendKeys("Jony");
        xpathOrCss(".//input[@value='single]").click();
        xpathOrCss(".//input[@value='dance]").click();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));

        driver.findElement(By.name("first name")).getText();

        driver.get("http://UserName:Password@Example.com");



    }

}

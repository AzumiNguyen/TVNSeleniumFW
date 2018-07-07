package objects;

import org.openqa.selenium.By;

public class BMIPage {


    /**
     * 1. String
     * 2. By (Page Factory)
     * 3. @FindBy() --> constructor (Page Factory)
     */
    public By metric_tab = By.xpath(".//a[.='Metric Units']");
    public By age_field = By.name("cage");
    public By male_rad = By.name("csex1");
    public By female_rad = By.name("csex2");
    public By height_field = By.name("cheightmeter");
    public By weight_field = By.name("ckg");
    public By calculate_button = By.xpath(".//input[@alt='Calculate']");
    public By result_label = By.cssSelector(".bigtext");
}

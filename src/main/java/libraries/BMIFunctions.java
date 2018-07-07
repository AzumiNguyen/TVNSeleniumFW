package libraries;

import objects.BMIPage;

import static supports.CommonFunctions.*;

public class BMIFunctions {

    BMIPage bmiPage = new BMIPage();

    public void selectMetricTab() {
        click(bmiPage.metric_tab);
    }

    public void fillBmiForm(String age, String gender, String height, String weight) {
        fillIn(bmiPage.age_field, age);
        if (gender.equalsIgnoreCase("male")) {
            click(bmiPage.male_rad);
        } else click(bmiPage.female_rad);

        fillIn(bmiPage.height_field, height);
        fillIn(bmiPage.weight_field, weight);
        click(bmiPage.calculate_button);
    }

    public String getResult() {
        return getText(bmiPage.result_label);
    }
}

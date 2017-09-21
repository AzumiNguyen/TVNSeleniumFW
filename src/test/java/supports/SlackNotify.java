package supports;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by hado on 5/20/17.
 */
public class SlackNotify implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("===========> > > >>onTestStart");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("===========> > > >>onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("===========> > > >>onTestFailure");
        System.out.println("ERROR LOG" + iTestResult.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("===========> > > >>onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("===========> > > >>onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("===========> > > >>onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        try {
            double totalPassedTest = iTestContext.getPassedTests().size();
            double totalTest = iTestContext.getFailedTests().size() + totalPassedTest;
            int currentTime = (int) (System.currentTimeMillis() / 1000);
            HttpPost request = new HttpPost("https://hooks.slack.com/services/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");
            String body = "{\n" +
                    "\"title\": \"AUTOMATION - SELENIUM - TEST\",\n" +
                    "    \"attachments\": [\n" +
                    "        {\n" +
                    "            \"title\": \"Summary Report\",\n" +
                    "            \"fields\": [\n" +
                    "                {\n" +
                    "                    \"title\": \"Pass rate\",\n" +
                    "                    \"value\": \"%s\",\n" +
                    "                    \"short\": true\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"title\": \"Environment\",\n" +
                    "                    \"value\": \"%s\",\n" +
                    "                    \"short\": true\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"color\": \"good\",\n" +
                    "            \"ts\":%d\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            double percentPassed = totalPassedTest / totalTest;


            HttpClient httpClient = HttpClientBuilder.create().build();

            StringEntity params = new StringEntity(String.format(body, String.format("%.1f", percentPassed * 100), "Chrome", currentTime));
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}

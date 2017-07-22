package supports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by hado on 5/20/17.
 */
public class Reports implements ITestListener {
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
        System.out.println("ERROR LOG"+iTestResult.getThrowable().toString());
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
        System.out.println("===========> > > >>onFinish");
    }
}

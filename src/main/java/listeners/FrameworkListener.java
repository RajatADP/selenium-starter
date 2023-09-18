package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import report.ExtentReport;

import static constants.FrameworkConstants.RETRYCOUNT;

public final class FrameworkListener implements IRetryAnalyzer, ITestListener {
    private int counter = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < RETRYCOUNT) {
            counter++;
            return true;
        }
        return false;
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReport();
    }
}

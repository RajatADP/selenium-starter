package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;
import enums.RunCategory;
import lombok.SneakyThrows;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.FrameworkAnnotations;

import java.util.Objects;

import static constants.FrameworkConstants.RETRYCOUNT;

public final class FrameworkListener implements IRetryAnalyzer, ITestListener {
    private int counter = 0;

    private static ExtentReports report;

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public boolean retry(ITestResult result) {
        if (counter < RETRYCOUNT) {
            counter++;
            return true;
        }
        return false;
    }

    @SneakyThrows
    private void initReport() {
        if (Objects.isNull(report)) {
            report = new ExtentReports();
            ExtentSparkReporter reporter = new ExtentSparkReporter(FrameworkConstants.REPORTPATH);
            reporter.config().setTheme(Theme.STANDARD);
            reporter.config().setReportName(FrameworkConstants.REPORTNAME);
            reporter.config().setDocumentTitle(FrameworkConstants.DOCUMENTNAME);
            report.attachReporter(reporter);
        }
    }

    @SneakyThrows
    private void createTest(String testName) {
        extentTest.set(report.createTest(testName));
    }

    @SneakyThrows
    private void addCategories(RunCategory[] categories) {
        for (RunCategory category : categories)
            extentTest.get().assignCategory(category.toString());
    }

    @SneakyThrows
    private void addAuthor(String author) {
        extentTest.get().assignAuthor(author);
    }

    @SneakyThrows
    private void flushReport() {
        if (Objects.nonNull(report)) {
            report.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        createTest(result.getName());
        addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
        addAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass(result.getName() + " passed");
        extentTest.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getName() + " failed");
        extentTest.remove();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip(result.getName() + " skipped");
        extentTest.remove();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        initReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        flushReport();
    }
}

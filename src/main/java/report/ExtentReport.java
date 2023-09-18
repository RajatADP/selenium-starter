package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;
import enums.RunCategory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.testng.ITestResult;
import utils.FrameworkAnnotations;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentReport {
    private static ExtentReports report;

    @SneakyThrows
    public static void initReport() {
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
    private static void addCategories(RunCategory[] categories) {
        for (RunCategory category : categories)
            ExtentTestManager.getExtentTest().assignCategory(category.toString());
    }

    @SneakyThrows
    private static void addAuthor(String author) {
        ExtentTestManager.getExtentTest().assignAuthor(author);
    }

    @SneakyThrows
    public static void createTest(ITestResult result) {
        ExtentTestManager.setExtentTest(report.createTest(result.getName()));
        addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
        addAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
    }

    @SneakyThrows
    public static void flushReport() {
        if (Objects.nonNull(report)) {
            report.flush();
            ExtentTestManager.unloadExtentTest();
        }
    }
}

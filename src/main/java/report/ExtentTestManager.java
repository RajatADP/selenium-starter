package report;

import com.aventstack.extentreports.ExtentTest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentTestManager {
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    protected static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    protected static void setExtentTest(ExtentTest test) {
        extentTest.set(test);
    }

    protected static void unloadExtentTest() {
        extentTest.remove();
    }
}

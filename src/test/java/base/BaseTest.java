package base;

import factories.DriverFactory;
import enums.SupportedBrowser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.FrameworkConfigs;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        SupportedBrowser browser = SupportedBrowser.valueOf(FrameworkConfigs.config.browser().toUpperCase());
        driver = DriverFactory.getDriver(browser, FrameworkConfigs.config.executionType());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        DriverFactory.unLoadDriver();
    }
}

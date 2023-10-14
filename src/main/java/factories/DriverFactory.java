package factories;

import enums.SupportedBrowser;
import exceptions.BrowserNotSupportedException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.FrameworkConfigs;

import java.net.URL;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    private static WebDriver driver;

    @SneakyThrows
    public static WebDriver getDriver(SupportedBrowser browser, String executionType) {
        if (executionType.equalsIgnoreCase("local")) {
            switch (browser) {
                case CHROME -> driver = setChromeDriver();
                case SAFARI -> driver = setSafariDriver();
                default -> throw new BrowserNotSupportedException("Browser " + browser + " is not supported");
            }
            DriverManager.setDriver(driver);
        } else if (executionType.equalsIgnoreCase("remote")) {
            switch (browser) {
                case CHROME -> driver = setRemoteChromeDriver();
                case SAFARI -> driver = setRemoteSafariDriver();
                default -> throw new BrowserNotSupportedException("Browser " + browser + " is not supported");
            }
            DriverManager.setDriver(driver);
        }

        return DriverManager.getDriver();
    }

    public static void unLoadDriver() {
        DriverManager.unLoad();
    }

    @SneakyThrows
    private static WebDriver setRemoteChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.setAcceptInsecureCerts(true);
        return new RemoteWebDriver(new URL(FrameworkConfigs.config.hubUrl()), chromeOptions);
    }

    @SneakyThrows
    private static WebDriver setRemoteSafariDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("safari");
        return new RemoteWebDriver(new URL(FrameworkConfigs.config.hubUrl()), capabilities);
    }

    private static WebDriver setSafariDriver() {
        return new SafariDriver();
    }

    private static WebDriver setChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //DOM access is ready, but other resources like images may still be loading
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.setAcceptInsecureCerts(true);
        return new ChromeDriver(chromeOptions);
    }
}

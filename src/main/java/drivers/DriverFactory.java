package drivers;

import enums.SupportedBrowser;
import exceptions.BrowserNotSupportedException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    private static WebDriver driver;

    @SneakyThrows
    public static WebDriver getDriver(SupportedBrowser browser) {
        switch (browser) {
            case CHROME -> driver = setChromeDriver();
            case SAFARI -> driver = setSafariDriver();
            default -> throw new BrowserNotSupportedException("Browser " + browser + " is not supported");
        }
        DriverManager.setDriver(driver);
        return DriverManager.getDriver();
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

package drivers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverManager {
    private static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadSafeDriver.get();
    }

    protected static void setDriver(WebDriver driver) {
        threadSafeDriver.set(driver);
    }

    public static void unLoad() {
        threadSafeDriver.remove();
    }
}

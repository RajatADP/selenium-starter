package utils;

import constants.FrameworkConstants;
import enums.LocatorStrategy;
import enums.WaitStrategy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import report.ExtentLogger;

import java.util.List;

import static factories.LocatorFactory.getByLocator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonUtils {

    @SneakyThrows
    public static String getParameter(String param) {
        return System.getProperty(param);
    }

    @SneakyThrows
    public static WebElement performExplicitWait(WebDriver driver, WaitStrategy strategy, LocatorStrategy locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, FrameworkConstants.EXPLICITWAITTIMEOUT);
        WebElement element;
        By by = getByLocator(locator, value);

        try {
            switch (strategy) {
                case VISIBLE -> element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                case CLICKABLE -> element = wait.until(ExpectedConditions.elementToBeClickable(by));
                default -> element = driver.findElement(by);
            }
            ExtentLogger.info("Found element by :" + by + "on the page");
        } catch (Exception ex) {
            ExtentLogger.fail("Unable to find element by :" + by + "on the page");
            throw new ElementNotInteractableException("Unable to find element by :" + by + "on the page");
        }

        return element;
    }
}

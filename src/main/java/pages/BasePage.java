package pages;

import enums.LocatorStrategy;
import enums.WaitStrategy;
import factories.LocatorFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import report.ExtentLogger;
import utils.CommonUtils;
import utils.FrameworkConfigs;

import java.util.function.Predicate;

public class BasePage {

    @SneakyThrows
    protected void openApp(WebDriver driver) {
        driver.get(FrameworkConfigs.config.url());
        ExtentLogger.pass("App opened successfully");
    }

    @SneakyThrows
    protected void sendKeys(WebDriver driver, LocatorStrategy locator, String value, WaitStrategy waitStrategy, String textValue) {
        WebElement element = CommonUtils.performExplicitWait(driver, waitStrategy, locator, value);
        element.sendKeys(textValue);
        ExtentLogger.pass("Entered " + textValue);
    }

    @SneakyThrows
    protected void click(WebDriver driver, LocatorStrategy locator, String value, WaitStrategy waitStrategy) {
        WebElement element = CommonUtils.performExplicitWait(driver, waitStrategy, locator, value);
        element.click();
        ExtentLogger.pass("Element clicked ");
    }

    @SneakyThrows
    protected void clickAnElementWithMatchingProperty(WebDriver driver, LocatorStrategy locator, String value, Predicate<WebElement> predicate) {
        WebElement element = driver.findElements(LocatorFactory.getByLocator(locator, value))
                .parallelStream()
                .filter(predicate)
                .findFirst().get();
        element.click();
    }

    @SneakyThrows
    protected WebElement getElement(WebDriver driver, LocatorStrategy locator, String value, WaitStrategy waitStrategy) {
        WebElement element = CommonUtils.performExplicitWait(driver, waitStrategy, locator, value);
        return element;
    }
}

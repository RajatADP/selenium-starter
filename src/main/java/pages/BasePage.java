package pages;

import enums.WaitStrategy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.FrameworkConfigs;

public class BasePage {

    @SneakyThrows
    protected void openApp(WebDriver driver) {
        driver.get(FrameworkConfigs.config.url());
        //ExtentLogger.pass("Entered " + value + " in " + elementName, isScreenshotNeeded);
    }

    @SneakyThrows
    protected void sendKeys(WebDriver driver, By by, WaitStrategy waitStrategy, String value) {
        WebElement element = CommonUtils.performExplicitWait(driver, waitStrategy, by);
        element.sendKeys(value);
        //ExtentLogger.pass("Entered " + value + " in " + elementName, isScreenshotNeeded);
    }

    @SneakyThrows
    protected void click(WebDriver driver, By by, WaitStrategy waitStrategy) {
        WebElement element = CommonUtils.performExplicitWait(driver, waitStrategy, by);
        element.click();
        //ExtentLogger.pass("Entered " + value + " in " + elementName, isScreenshotNeeded);
    }

    @SneakyThrows
    protected WebElement getElement(WebDriver driver, By by, WaitStrategy waitStrategy) {
        WebElement element = CommonUtils.performExplicitWait(driver, waitStrategy, by);
        return element;
        //ExtentLogger.pass("Entered " + value + " in " + elementName, isScreenshotNeeded);
    }
}

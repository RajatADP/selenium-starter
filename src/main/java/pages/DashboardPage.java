package pages;

import enums.WaitStrategy;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import report.ExtentLogger;

import static enums.LocatorStrategy.XPATH;

public class DashboardPage extends BasePage {

    private WebDriver driver;
    private final String menuItem = "//span[text()='%s']";

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    @SneakyThrows
    public WebElement DashboardPageLoaded() {
        return getElement(driver, XPATH, String.format(menuItem, "Dashboard"), WaitStrategy.VISIBLE);
    }

    @SneakyThrows
    public MyInfoPage navigateToMyInfoPage() {
        click(driver, XPATH, String.format(menuItem, "My Info"), WaitStrategy.VISIBLE);
        ExtentLogger.pass("Clicked successfully on " + String.format(menuItem, "My Info"));
        return new MyInfoPage(driver);
    }
}

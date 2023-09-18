package pages;

import enums.WaitStrategy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import report.ExtentLogger;

public class DashboardPage extends BasePage {

    private WebDriver driver;
    private final By pageHeader = By.xpath("//span[text()='Dashboard']");
    private final By myInfoSection = By.xpath("//span[text()='My Info']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    @SneakyThrows
    public WebElement DashboardPageLoaded() {
        return getElement(driver, pageHeader, WaitStrategy.VISIBLE);
    }

    @SneakyThrows
    public MyInfoPage navigateToMyInfoPage() {
        click(driver, myInfoSection, WaitStrategy.VISIBLE);
        ExtentLogger.pass("Clicked successfully on " + myInfoSection);
        return new MyInfoPage(driver);
    }
}

package pages;

import enums.WaitStrategy;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import report.ExtentLogger;

import static enums.LocatorStrategy.CSS;
import static enums.LocatorStrategy.NAME;

public final class LoginPage extends BasePage {

    private WebDriver driver;

    private final String userNameField = "username";
    private final String passwordField = "password";
    private final String loginBtn = ".orangehrm-login-button";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @SneakyThrows
    public DashboardPage loginIntoHRM(String userName, String password) {
        openApp(driver);
        sendKeys(driver, NAME, userNameField, WaitStrategy.CLICKABLE, userName);
        sendKeys(driver, NAME, passwordField, WaitStrategy.CLICKABLE, password);
        //click(driver, CSS, loginBtn, WaitStrategy.CLICKABLE);
        clickAnElementWithMatchingProperty(driver, CSS,  loginBtn, (t)-> t.getText().equals("Login"));
        ExtentLogger.pass("Login successful");
        return new DashboardPage(driver);
    }
}

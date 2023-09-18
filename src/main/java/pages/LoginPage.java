package pages;

import constants.FrameworkConstants;
import enums.WaitStrategy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FrameworkConfigs;

public final class LoginPage extends BasePage {

    private WebDriver driver;

    private final By userNameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginBtn = By.cssSelector(".orangehrm-login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @SneakyThrows
    public DashboardPage loginIntoHRM(String userName, String password) {
        openApp(driver);
        sendKeys(driver, userNameField, WaitStrategy.CLICKABLE, userName);
        sendKeys(driver, passwordField, WaitStrategy.CLICKABLE, password);
        click(driver, loginBtn, WaitStrategy.CLICKABLE);
        return new DashboardPage(driver);
    }

}

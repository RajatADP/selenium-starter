package pages;

import enums.WaitStrategy;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static enums.LocatorStrategy.XPATH;

public final class MyInfoPage extends BasePage {

    private WebDriver driver;

    private final String pageHeader = "//h6[text()='PIM']";

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    @SneakyThrows
    public WebElement MyInfoPageLoaded() {
        return getElement(driver, XPATH, pageHeader, WaitStrategy.VISIBLE);
    }

}

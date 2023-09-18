package pages;

import enums.WaitStrategy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class MyInfoPage extends BasePage {

    private WebDriver driver;

    private final By pageHeader = By.xpath("//h6[text()='PIM']");

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    @SneakyThrows
    public WebElement MyInfoPageLoaded() {
        return getElement(driver, pageHeader, WaitStrategy.VISIBLE);
    }

}

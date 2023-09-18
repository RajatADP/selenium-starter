package regression;

import base.BaseTest;
import enums.RunCategory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.FrameworkAnnotations;

public class LoginTest extends BaseTest {
    @FrameworkAnnotations(author = "Rajat", category = {RunCategory.SMOKE})
    @Test
    void loginToHRM() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.loginIntoHRM("Admin", "admin123");
        Assert.assertTrue(dashboardPage.DashboardPageLoaded().isDisplayed());
    }
}

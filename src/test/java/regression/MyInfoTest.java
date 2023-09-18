package regression;

import base.BaseTest;
import enums.RunCategory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;
import utils.FrameworkAnnotations;

public class MyInfoTest extends BaseTest {
    @FrameworkAnnotations(author = "Swati", category = {RunCategory.REGRESSION})
    @Test
    void validateMyInfo() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.loginIntoHRM("Admin", "admin123");
        MyInfoPage myInfoPage = dashboardPage.navigateToMyInfoPage();
    }
}

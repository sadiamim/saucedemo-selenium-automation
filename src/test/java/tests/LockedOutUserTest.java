package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("SauceDemo Application")
@Feature("Login Feature")
public class LockedOutUserTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    @Story("Locked Out User Login")
    @Description("Verify locked user cannot login")
    @Severity(SeverityLevel.CRITICAL)
    public void lockedOutUserLoginTest() {

        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();

        assert errorMessage.contains("locked out");
    }
}
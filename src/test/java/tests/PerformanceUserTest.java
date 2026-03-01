package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import io.qameta.allure.*;

@Epic("SauceDemo Application")
@Feature("Login Feature")
public class PerformanceUserTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    @Story("Performance User Login")
    @Description("Verify that performance user can login successfully")
    @Severity(SeverityLevel.NORMAL)
    public void performanceUserLoginTest() {

        loginPage.enterUsername("performance_glitch_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String header = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(header, "Products");
    }
}
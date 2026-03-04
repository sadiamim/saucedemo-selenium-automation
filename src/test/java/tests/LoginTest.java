package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("SauceDemo Application")
@Feature("Login Module")
public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(driver);
    }

    @Story("Valid Login Scenario")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify that standard user can login successfully")
    public void validLoginTest() {

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String header = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(header, "Products");

        Assert.assertEquals(loginPage.getPageTitle(), "Products");
        System.out.println("Login test executed successfully");

        Assert.assertEquals("Actual", "WrongValue");
    }
}
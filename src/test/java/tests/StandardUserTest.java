package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("SauceDemo Application")
@Feature("Login Feature")
public class StandardUserTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    @Story("Standard User Login")
    @Description("Verify that standard user can login successfully and navigate to products page")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Sadia Mim")
    public void standardUserLoginTest() {

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String header = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(header, "Products");
        driver.findElement(By.className("title")).getText();
    }
}
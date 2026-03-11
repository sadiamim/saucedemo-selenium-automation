package pages;

import pages.InventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class LoginPage {
    WebDriver driver;

    // Locators
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("h3[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public InventoryPage login(String username, String password){

        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        return new InventoryPage(driver);
    }

    // Actions with Allure Steps

    @Step("Enter username: {0}")
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click login button")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

//    @Step("Login with username: {0}")
//    public void login(String username, String password) {
//        enterUsername(username);
//        enterPassword(password);
//        clickLogin();
//    }

    @Step("Get error message")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    @Step("Get page title")
    public String getPageTitle() {
        return driver.findElement(By.className("title")).getText();
    }
}
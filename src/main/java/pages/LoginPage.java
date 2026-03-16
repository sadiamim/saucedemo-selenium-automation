package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;


public class LoginPage extends BasePage{

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Actions with Allure Steps
    public void enterUsername(String username) {
        wait.waitForElementVisible(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {

        wait.waitForElementVisible(passwordField).sendKeys(password);
    }

    public void clickLogin() {

        wait.waitForElementClickable(loginButton).click();
    }

    public InventoryPage login(String username, String password) {

    enterUsername(username);
    enterPassword(password);
    clickLogin();

    return new InventoryPage(driver);
    }

    @Step("Get error message")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    @Step("Get page title")
    public String getPageTitle() {
        return driver.findElement(By.className("title")).getText();
    }

    @Step("Verify inventory page is displayed")
    public boolean isInventoryPageDisplayed() {
        By inventoryContainer = null;
        return driver.findElement(inventoryContainer).isDisplayed();
    }

    @Step("Get total number of products on inventory page")
    public int getProductCount() {
        By products = null;
        return driver.findElements(products).size();
    }

    @Step("Sort products by price: Low to High")
    public void sortByLowToHigh() {
    }

    @Step("Add backpack product to cart")
    public void addBackpackToCart() {
        By backpackAddButton = null;
        driver.findElement(backpackAddButton).click();
    }
}

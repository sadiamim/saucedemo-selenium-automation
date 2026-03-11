package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    // Locators
    private By inventoryContainer = By.id("inventory_container");
    private By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By sortDropdown = By.className("product_sort_container");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify inventory page loaded
    public boolean isInventoryPageDisplayed() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }

    // Add backpack to cart
    public void addBackpackToCart() {
        driver.findElement(backpackAddButton).click();
    }

    // Get cart item count
    public String getCartItemCount() {
        return driver.findElement(cartBadge).getText();
    }
}
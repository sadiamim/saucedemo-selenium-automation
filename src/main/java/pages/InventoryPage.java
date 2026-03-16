package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import utils.WaitUtils;

public class InventoryPage extends BasePage {

    WebDriver driver;
    WaitUtils wait;

    // Locators
    private By inventoryContainer = By.id("inventory_container");
    private By products = By.className("inventory_item");
    private By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By sortDropdown = By.className("product_sort_container");
    private By productPrices = By.className("inventory_item_price");
    private By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    // Constructor
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    // Verify inventory page loaded
    public boolean isInventoryPageDisplayed() {
        return wait.waitForElementVisible(inventoryContainer).isDisplayed();
    }


    // Add backpack to cart
    public void addBackpackToCart() {
        wait.waitForElementClickable(backpackAddButton).click();
    }

    // Get cart item count
    public String getCartItemCount() {
        return driver.findElement(cartBadge).getText();
    }

    public String getPageTitle(){
        return driver.findElement(By.className("title")).getText();
    }

    // Get number of products
    public int getProductCount() {
        wait.waitForElementVisible(products);
        return driver.findElements(products).size();
    }

    public void sortByLowToHigh() {

        Select select = new Select(driver.findElement(sortDropdown));

        select.selectByVisibleText("Price (low to high)");
    }


    public List<Double> getProductPrices() {

        List<WebElement> priceElements = driver.findElements(productPrices);

        List<Double> prices = new ArrayList<>();

        for (WebElement price : priceElements) {

            String priceText = price.getText().replace("$", "");

            prices.add(Double.parseDouble(priceText));
        }

        return prices;
    }

    public void removeBackpackFromCart() {

        driver.findElement(removeBackpackButton).click();

    }

    public boolean isCartBadgeDisplayed() {
        return false;
    }

    public CartPage openCart() {

        driver.findElement(cartIcon).click();

        return new CartPage(driver);
    }
}
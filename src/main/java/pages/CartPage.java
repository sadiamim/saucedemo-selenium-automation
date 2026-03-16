package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

public class CartPage {

    WebDriver driver;

    private By cartItem = By.className("cart_item");
    private By checkoutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");
    private By removeButton = By.id("remove-sauce-labs-backpack");

    public boolean isCartPageDisplayed() {
        return driver.getCurrentUrl().contains("cart.html");
    }

    public int getCartItemCount() {

        return driver.findElements(cartItem).size();

    }

    public void removeProduct() {

        driver.findElement(removeButton).click();

    }

    public CheckoutPage clickCheckout() {

        driver.findElement(checkoutButton).click();

        return new CheckoutPage(driver);
    }

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

}

package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartItem = By.className("cart_item");
    private By checkoutButton = By.id("checkout");
//    private By continueShoppingButton = By.id("continue-shopping");
    private By removeButton = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageDisplayed() {
        return driver.getCurrentUrl().contains("cart.html");
    }

    public int getCartItemCount() {

        wait.waitForElementVisible(cartItem);
        return driver.findElements(cartItem).size();

    }

    public void removeProduct() {

        wait.waitForElementClickable(removeButton).click();

    }

    public CheckoutPage clickCheckout() {

        wait.waitForElementClickable(checkoutButton).click();
        return null;
    }

}

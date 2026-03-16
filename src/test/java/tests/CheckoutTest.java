package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckoutPageLoads() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addBackpackToCart();

        CartPage cartPage = inventoryPage.openCart();

        CheckoutPage checkoutPage = cartPage.clickCheckout();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
    }
}
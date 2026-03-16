package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void verifyCartPageLoads() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addBackpackToCart();

        CartPage cartPage = inventoryPage.openCart();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }
}
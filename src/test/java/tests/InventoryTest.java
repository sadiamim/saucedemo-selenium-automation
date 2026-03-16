package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class InventoryTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isInventoryPageDisplayed());

        inventoryPage.addBackpackToCart();

        Assert.assertEquals(inventoryPage.getCartItemCount(), "1");

        Assert.assertEquals(inventoryPage.getPageTitle(),"Products");
    }

    public void verifyProductCount() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        int productCount = inventoryPage.getProductCount();

        Assert.assertEquals(productCount, 6);
    }

    public void verifyPriceSortingLowToHigh() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        inventoryPage.sortByLowToHigh();

        List<Double> actualPrices = inventoryPage.getProductPrices();

        List<Double> sortedPrices = new ArrayList<>(actualPrices);

        Collections.sort(sortedPrices);

        Assert.assertEquals(actualPrices, sortedPrices);

    }

    public void verifyAddProductToCart() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addBackpackToCart();

        By cartBadge = null;
        String badgeText = driver.findElement(cartBadge).getText();
        int cartCount = Integer.parseInt(badgeText);
        
        Assert.assertEquals(cartCount, 1);

    }

    @Test
    public void verifyRemoveProductFromCart() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addBackpackToCart();

        inventoryPage.removeBackpackFromCart();

        boolean cartVisible = inventoryPage.isCartBadgeDisplayed();

        Assert.assertFalse(cartVisible);

    }
}
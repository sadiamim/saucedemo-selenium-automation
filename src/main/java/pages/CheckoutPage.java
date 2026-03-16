package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    // Locators
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");

    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    private By orderConfirmation = By.className("complete-header");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Enter First Name
    public void enterFirstName(String firstName) {
        wait.waitForElementVisible(firstNameField).sendKeys(firstName);
    }

    // Enter Last Name
    public void enterLastName(String lastName) {
        wait.waitForElementVisible(lastNameField).sendKeys(lastName);
    }

    // Enter Postal Code
    public void enterPostalCode(String postalCode) {
        wait.waitForElementVisible(postalCodeField).sendKeys(postalCode);
    }

    // Click Continue
    public void clickContinue() {
        wait.waitForElementClickable(continueButton).click();
    }

    // Click Finish
    public void clickFinish() {
        wait.waitForElementClickable(finishButton).click();
    }

    // Verify Order Completion
    public String getOrderConfirmationMessage() {
        return wait.waitForElementVisible(orderConfirmation).getText();
    }

    public boolean isCheckoutPageDisplayed() {
        return false;
    }
}
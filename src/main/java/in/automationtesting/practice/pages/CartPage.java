package in.automationtesting.practice.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {


    private By getProduct(String productName) {
        return By.xpath("//tr[contains(@class,'cart_item')]//td[contains(@class,'product-name')]//a[text()='" + productName + "']");
    }

    private final By checkoutButton_a = By.xpath("//a[contains(@class,'checkout')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Checkout")
    public CheckoutPage navigateToCheckout() {
        actionsBot.click(checkoutButton_a);
        return new CheckoutPage(driver);
    }

    //region Assertions
    @Step("Assert product is visible")
    public void assertProductIsVisible(String productName) {
        Assert.assertTrue(actionsBot.isElementDisplayed(getProduct(productName)));
    }
    //endregion
}

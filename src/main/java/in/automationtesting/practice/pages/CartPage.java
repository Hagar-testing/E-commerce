package in.automationtesting.practice.pages;

import in.automationtesting.practice.engine.StringUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static in.automationtesting.practice.engine.StringUtils.getNumberFromText;

public class CartPage extends BasePage {


    private By getProduct(String productName) {
        return By.xpath("//tr[contains(@class,'cart_item')]//td[contains(@class,'product-name')]//a[text()='" + productName + "']");
    }

    private By getProductPrice(String productName) {
        return By.xpath("//tr[contains(@class,'cart_item')]//td[contains(@class,'product-name')]//a[text()='" + productName + "']/parent::td/following-sibling::td[contains(@class, 'price')]");
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
    @Step("Assert {productName} is visible in cart")
    public void assertProductIsVisible(String productName) {
        Assert.assertTrue(actionsBot.isElementDisplayed(getProduct(productName)));
    }

    @Step("Assert {productName} is displayed with price {price}")
    public void assertProductIsPriceIsDisplayedCorrectly(String productName, String price) {
        Assert.assertEquals(getNumberFromText(actionsBot.getElementText(getProductPrice(productName))), price);
    }



    //endregion
}

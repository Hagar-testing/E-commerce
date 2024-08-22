package in.automationtesting.practice.pages;

import in.automationtesting.practice.engine.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static in.automationtesting.practice.engine.StringUtils.getNumberFromText;

public class HomePage extends BasePage {

    private By getProduct(String productName) {
        return By.xpath("//a[contains(@class, 'woocommerce-LoopProduct-link')]//h3[text()='" + productName + "']");
    }

    private By getProductPrice(String productName) {
        return By.xpath("//a[contains(@class, 'woocommerce-LoopProduct-link')]//h3[text()='" + productName + "']/following-sibling::span[@class='price']//ins");
    }

    private By addToCartButton(String productName) {
        return By.xpath("//a[contains(@class, 'woocommerce-LoopProduct-link')]//h3[text()='" +productName + "']/parent::a/following-sibling::a[contains(@class, 'cart')]");
    }

    private final Header header;

    public HomePage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    @Step("Open Home Page")
    public HomePage load(){
        driver.get(ConfigUtils.getBaseUrl());
        return this;
    }

    @Step("Add Product: {productName} to cart")
    public HomePage addProductToCart(String productName) {
        actionsBot.click(addToCartButton(productName));
        return this;
    }

    @Step("Navigate to Cart")
    public CartPage navigateToCart() {
        header.clickOnCartIcon();
        return new CartPage(driver);
    }


    //region Assertions
    @Step("Assert Product: {productName} is visible")
    public void assertProductIsVisible(String productName) {
        Assert.assertTrue(actionsBot.isElementDisplayed(getProduct(productName)));
    }

    @Step("Assert Product: {productName} price is displayed correctly")
    public void assertProductPriceIsDisplayedCorrectly(String productName, String price) {
        Assert.assertEquals((getNumberFromText(
                actionsBot.getElementText(getProductPrice(productName)))
        ), price);
    }
    //endregion

}

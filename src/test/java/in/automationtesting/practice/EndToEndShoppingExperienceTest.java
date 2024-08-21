package in.automationtesting.practice;


import in.automationtesting.practice.engine.JsonUtils;
import in.automationtesting.practice.engine.factory.DriverFactory;
import in.automationtesting.practice.engine.listener.TestngListener;
import in.automationtesting.practice.pages.CartPage;
import in.automationtesting.practice.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.google.gson.JsonObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static in.automationtesting.practice.constants.FilesPathConstants.CHECKOUT_DATA_FILE_PATH;
import static in.automationtesting.practice.engine.JsonUtils.getTestData;

@Listeners(TestngListener.class)
@Feature("Checkout Flow")
public class EndToEndShoppingExperienceTest {

    private JsonObject data ;
    WebDriver driver;

    @Story("Products List")
    @Description("Given I am on the home page, When a product is displayed, Then its title should be visible")
    @Test(description = "Verify Product Title Visibility")
    public void verifyProductTitleIsVisible(){
        new HomePage(getDriver())
                .load()
                .assertProductIsVisible(
                        getTestData(data, "products.first_product.title"));
    }


    @Story("Products List")
    @Description("Given a product is displayed, When its price is shown, Then it should match the expected price")
    @Test(dependsOnMethods = {"verifyProductTitleIsVisible"}, description = "Verify Product Price Accuracy")
    public void verifyProductPriceIsDisplayedCorrectly() {
        new HomePage(getDriver()).assertProductPriceIsDisplayedCorrectly(
                getTestData(data, "products.first_product.title"),
                getTestData(data, "products.first_product.price"));
    }


    @Story("Shopping Cart")
    @Description("Given a product is displayed, When I add it to the cart, Then it should appear in the cart")
    @Test(dependsOnMethods = {"verifyProductPriceIsDisplayedCorrectly"}, description = "Verify Product Added to Cart")
    public void verifyItemIsAddedCorrectlyToCart() {
        new HomePage(getDriver()).addProductToCart(
                        getTestData(data, "products.first_product.title"))
                .navigateToCart()
                .assertProductIsVisible(
                        getTestData(data, "products.first_product.title")
                );
    }

    @Story("Shopping Cart")
    @Description("Given a product is displayed and added to the cart, When I view the cart, Then the product's price should be displayed correctly")
    @Test(dependsOnMethods = {"verifyItemIsAddedCorrectlyToCart"}, description = "Verify Product Added to Cart")
    public void verifyItemPriceIsCorrect() {
        new CartPage(getDriver())
                .assertProductIsPriceIsDisplayedCorrectly(
                        getTestData(data, "products.first_product.title"),
                        getTestData(data, "products.first_product.price")
                );
    }


    @Story("Checkout Process")
    @Description("Given I am in the cart, When I proceed to checkout, Then the billing form should be displayed")
    @Test(dependsOnMethods = {"verifyItemPriceIsCorrect"}, description = "Verify Billing Form Visibility")
    public void verifyBillingFormIsDisplayed() {
        new CartPage(driver)
                .navigateToCheckout()
                .assertFormTitleIsDisplayed();
    }


    //region WebDriver
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return driver;
    }
    //endregion

    //region Configurations
    @BeforeClass
    public void beforeClass(){
        data = JsonUtils.parseJsonFile(CHECKOUT_DATA_FILE_PATH);
        setDriver(new DriverFactory().initializeDriver());

    }
    @AfterClass
    public void afterClass(){
        getDriver().quit();

    }
    //endregion

}

package in.automationtesting.practice.testscenario;


import in.automationtesting.practice.engine.JsonUtils;
import in.automationtesting.practice.engine.factory.DriverFactory;
import in.automationtesting.practice.engine.listener.TestngListener;
import in.automationtesting.practice.pages.CartPage;
import in.automationtesting.practice.pages.HomePage;
import io.qameta.allure.Feature;
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
public class CheckoutFlowTest {

    private JsonObject data ;
    WebDriver driver;



    @Test
    public void assertingBookExists(){
        new HomePage(getDriver())
                .load()
                .assertProductIsVisible(
                getTestData(data, "products.first_product.title"));
    }


    @Test(dependsOnMethods = {"assertingBookExists"})
    public void assertingProductPriceIsDisplayedCorrectly() {
        new HomePage(getDriver()).assertProductPriceIsDisplayedCorrectly(
                getTestData(data, "products.first_product.title"),
                getTestData(data, "products.first_product.price"));
    }


    @Test(dependsOnMethods = {"assertingProductPriceIsDisplayedCorrectly"})
    public void assertingItemIsAddedCorrectlyToCart() {
        new HomePage(getDriver()).addProductToCart(
                getTestData(data, "products.first_product.title"))
                .navigateToCart()
                .assertProductIsVisible(
                        getTestData(data, "products.first_product.title")
                );
    }


    @Test(dependsOnMethods = {"assertingItemIsAddedCorrectlyToCart"})
    public void AssetFormBillingIsDisplayed() {
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

package in.automationtesting.practice.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    private final By FormTitle = By.xpath("//h3[.='Billing Details']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //region Assertions
    @Step("Assert Form Title is displayed")
    public void assertFormTitleIsDisplayed() {
        Assert.assertTrue(actionsBot.isElementDisplayed(FormTitle));
    }
    //endregion
}

package in.automationtesting.practice.pages;

import in.automationtesting.practice.engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    WebDriver driver;

    ActionsBot actionsBot;

    private final By cartIcon = By.xpath("//a[contains(@class,'wpmenucart-contents')]");

    private final By cartQuantity = By.className("cartcontents");

    public Header(WebDriver driver) {
        this.driver = driver;
        actionsBot = new ActionsBot(driver);
    }

    @Step("Click on Cart Icon")
    public void clickOnCartIcon() {
        actionsBot
                .waitForTextToBePresentInElement(cartQuantity,"1 Item")
                .click(cartIcon);
    }

}

package in.automationtesting.practice.pages;

import in.automationtesting.practice.engine.ActionsBot;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected final WebDriver driver;
    protected final ActionsBot actionsBot;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actionsBot = new ActionsBot(driver);
    }
}

package in.automationtesting.practice.engine;

import org.openqa.selenium.WebDriver;

public class BrowserBot {


    public  BrowserBot navigateBack(WebDriver driver){
        driver.navigate().back();
        return new BrowserBot();
    }
}

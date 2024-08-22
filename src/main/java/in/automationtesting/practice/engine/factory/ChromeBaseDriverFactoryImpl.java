package in.automationtesting.practice.engine.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeBaseDriverFactoryImpl implements BaseDriverFactory {

    @Override
    public WebDriver getDriver() {
        try {

            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.setCapability("browserVersion", "100");
            chromeOptions.setCapability("platformName", "Linux");
//// Showing a e2e.yml name instead of the session id in the Grid UI
            chromeOptions.setCapability("se:name", "Hager");
//// Other type of metadata can be seen in the Grid UI by clicking on the
//// session info or via GraphQL
            // chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");
////
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--no-sandbox");
            //   chromeOptions.addArguments("--disable-dev-shm-usage");
            // chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--remote-allow-origins=*");
            return new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}

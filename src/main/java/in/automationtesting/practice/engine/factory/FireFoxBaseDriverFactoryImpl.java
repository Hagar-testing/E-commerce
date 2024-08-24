package in.automationtesting.practice.engine.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FireFoxBaseDriverFactoryImpl implements BaseDriverFactory {
    @Override
    public WebDriver getDriver() {
        try {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("platformName", "Linux");
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--no-sandbox");
            firefoxOptions.addArguments("--remote-allow-origins=*");
            return new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

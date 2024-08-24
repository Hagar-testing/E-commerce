package in.automationtesting.practice.engine.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeBaseDriverFactoryImpl implements BaseDriverFactory {

    @Override
    public WebDriver getDriver() {
        try {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setCapability("platformName", "Linux");
            edgeOptions.addArguments("--headless=new");
            edgeOptions.addArguments("--no-sandbox");
            edgeOptions.addArguments("--remote-allow-origins=*");
            return new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}

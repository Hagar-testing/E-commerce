package in.automationtesting.practice.engine.factory;

import in.automationtesting.practice.engine.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import static in.automationtesting.practice.engine.ConfigUtils.getBrowser;
import static in.automationtesting.practice.engine.constants.ConfigConstants.BROWSER;
import static in.automationtesting.practice.engine.enums.BrowserType.CHROME;



public class DriverFactory {

    public WebDriver initializeDriver() {
        WebDriver driver;

        BrowserType browser = BrowserType.getByKey(getBrowser().toLowerCase());

        switch (browser) {
            case CHROME -> {
                ChromeBaseDriverFactoryImpl ChromeTestFactoryImpl = new ChromeBaseDriverFactoryImpl();
                driver = ChromeTestFactoryImpl.getDriver();
            }
            case FIREFOX -> {
                FireFoxBaseDriverFactoryImpl fireFoxWebDriverFactory = new FireFoxBaseDriverFactoryImpl();
                driver = fireFoxWebDriverFactory.getDriver();
            }
            case EDGE -> {
                EdgeBaseDriverFactoryImpl edgeWebDriverFactory = new EdgeBaseDriverFactoryImpl();
                driver = edgeWebDriverFactory.getDriver();
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser.getKey());
        }

        configureDriver(driver);
        return driver;
    }

    private void configureDriver(WebDriver driver) {
        driver.manage().window().maximize();
    }
}

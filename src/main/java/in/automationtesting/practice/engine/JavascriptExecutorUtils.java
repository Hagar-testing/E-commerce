package in.automationtesting.practice.engine;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptExecutorUtils {


    public static JavascriptExecutor getJavascriptExecutor(WebDriver driver) {
        return (JavascriptExecutor) driver;
    }

    public static void executeJavaScriptClick(WebDriver driver,By elementLocator) {
        getJavascriptExecutor(driver).executeScript("arguments[arguments.length - 1].click();",
                driver.findElement(elementLocator));
    }

    public static void sendInput(WebDriver driver, By elementLocator, String text){
        getJavascriptExecutor(driver).executeScript("arguments[0].setAttribute('value', '" + text + "')",
                driver.findElement(elementLocator));
    }

    public static void findElement(WebDriver driver,By elementLocator){
        getJavascriptExecutor(driver).executeScript("arguments[0].scrollIntoView(false);",  driver.findElement(elementLocator));

    }

}

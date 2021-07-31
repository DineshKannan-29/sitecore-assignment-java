package utils;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Utils {
    private static final Logger logger = LogManager.getLogger(Utils.class);

    public static WebDriver setupBrowser(String browserName, String driverPath) {
        setSystemProperty(browserName, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void setSystemProperty(String browserName, String driverPath) {
        if (browserName.toLowerCase().contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath);
        } else {
            throw new RuntimeException("This test setup supports only chrome and firefox browser");
        }

    }

    public static WebElement waitUntilElementToBeClickable(WebDriver driver, WebElement webElement) {
        logger.info("Waiting until element " + webElement + " is clickable");
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static WebElement waitUntilVisibilityOfElement(WebDriver driver, WebElement webElement) {
        logger.info("Waiting until element " + webElement + " is visible");
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static String getPageTile(WebDriver driver) {
        return driver.getTitle();
    }

    public static void goToLink(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}

package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseScript {

    protected WebDriver driver;
    protected WebDriverWait wait;

    /* LOG */
    protected static final Logger log = LogManager.getLogger(BaseScript.class);

    public void log(String message) {
        log.info(message);
    }

    /* SETUP */
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /* TEARDOWN */
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /* WAITS */
    public void waitVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /* ACTIONS */
    public void click(WebElement element) {
        waitClickable(element);
        element.click();
    }

    public void type(WebElement element, String value) {
        waitVisible(element);
        element.clear();
        element.sendKeys(value);
    }
}
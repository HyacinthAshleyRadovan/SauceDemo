package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseScript {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final Logger log = LogManager.getLogger(BaseScript.class);

    public void log(String message) {
        log.info(message);
    }

    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-password-manager-ui");
        options.addArguments("--disable-autofill");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options); // ← USE OPTIONS

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void waitVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

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
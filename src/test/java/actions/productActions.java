package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class productActions {
    WebDriver driver;
    WebDriverWait wait;

    public productActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Helper method to "Add to Cart" button for a specific product
    public WebElement addToCart(String productName) {
        String productNameKebab = productName.toLowerCase().replace(" ", "-");
        String dynamicXpath = String.format("//button[@data-test='add-to-cart-%s']", productNameKebab);
        return driver.findElement(By.xpath(dynamicXpath));
    }

    // Helper method to "Remove from Cart" button for a specific product
    public WebElement removeFromCart(String productName) {
        String productNameKebab = productName.toLowerCase().replace(" ", "-");
        String dynamicXpath = String.format("//button[@data-test='remove-%s']", productNameKebab);
        return driver.findElement(By.xpath(dynamicXpath));
    }

    public WebElement getDynamicMenuOption(String optionName) {
        String xpath = String.format("//a[contains(text(), '%s')]", optionName);
        return wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(xpath)));
    }
}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class itemPage {
    private WebDriver driver;

    public itemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='add-to-cart-%s']")
    public WebElement dynamicAddToCart;

    @FindBy(xpath = "//span[@class='select_container']")
    public WebElement filterItemsBtn;

    @FindBy(xpath = "//option[contains(text(),'%s')]")
    public WebElement filterOptions;

    @FindBy(xpath = "// *[@class='app_logo' and contains(., 'Swag Labs')]")
    public WebElement appLogo;
}

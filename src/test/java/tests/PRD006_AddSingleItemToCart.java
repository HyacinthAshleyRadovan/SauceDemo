package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;
import actions.productActions;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.WebElement;

public class PRD006_AddSingleItemToCart extends BaseScript {

    loginFlow log;
    itemPage item;
    productActions prodAct;

    @BeforeMethod
    public void start() {
        setUp();
        log = new loginFlow(driver, wait);
        prodAct = new productActions(driver);
        item = new itemPage(driver, wait);
        log.loginAs("standardUser");
    }

    @Test
    public void AddSingleItemToCart() {

        log("Starting test: Add Single Item To Cart");

        List<WebElement> productNames = item.productName;

        for (int i = 0; i < productNames.size(); i++) {
            String name = productNames.get(i).getText();
            if (name.equals("Sauce Labs Backpack")) {
                prodAct.addToCart(name).click();
                waitForLoadingComplete(5);
                log("Added " + name + " to cart");
                break;
            }
            assertThat(item.cartBadge.getText()).isEqualTo("1");
            log("Verified that the cart count is updated to 1 after adding the item");
        }

        log("Successfully added a single item to the cart");

    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
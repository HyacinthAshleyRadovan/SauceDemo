package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;
import actions.productActions;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.WebElement;

public class PRD007_AddMultipleItemToCart extends BaseScript {

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
    public void AddMultipleItemsToCart() {

        log("Starting test: Add Multiple Items To Cart");

        List<WebElement> productNames = item.productName;
        int itemsAdded = 0;
        String[] itemsToAdd = { "Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt" };

        for (int i = 0; i < productNames.size(); i++) {
            String name = productNames.get(i).getText();
            for (String itemName : itemsToAdd) {
                if (name.equals(itemName)) {
                    prodAct.addToCart(name).click();
                    waitForLoadingComplete(5);
                    log("Added " + name + " to cart");
                    itemsAdded++;
                    assertThat(item.cartBadge.getText()).isEqualTo(String.valueOf(itemsAdded));
                }
            }
        }

        log("Successfully added multiple items to the cart");

    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
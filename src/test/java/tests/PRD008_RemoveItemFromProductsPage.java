package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;
import actions.productActions;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.WebElement;

public class PRD008_RemoveItemFromProductsPage extends BaseScript {

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
    public void RemoveItemFromProductsPage() {

        log("Starting test: Remove Item From Products Page");

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
        waitForLoadingComplete(5);
        prodAct.removeFromCart("Sauce Labs Backpack").click();
        assertThat(item.cartContainer.getText()).isEmpty();

        log("Successfully removed item from the cart");

    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
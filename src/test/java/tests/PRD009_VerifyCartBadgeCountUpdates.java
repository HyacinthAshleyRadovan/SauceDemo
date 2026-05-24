package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;
import actions.productActions;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.WebElement;

public class PRD009_VerifyCartBadgeCountUpdates extends BaseScript {

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
    public void VerifyCartBadgeCountUpdates() {

        log("Starting test: Verify Cart Badge Count Updates");
        List<WebElement> productNames = item.productName;
        int itemsAdded = 0;
        for (int i = 0; i < productNames.size() && itemsAdded < 3; i++) {
            String name = productNames.get(i).getText();
            prodAct.addToCart(name).click();
            waitForLoadingComplete(5);
            itemsAdded++;

        }
        assertThat(item.cartBadge.getText()).isEqualTo(String.valueOf(itemsAdded));
        log("Successfully verified cart badge count updates after adding an item to the cart");

    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
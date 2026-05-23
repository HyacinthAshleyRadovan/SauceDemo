package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.WebElement;

public class PRD002_VerifyProductListIsDisplayed extends BaseScript {

    loginFlow log;
    itemPage item;

    @BeforeMethod
    public void start() {
        setUp();
        log = new loginFlow(driver, wait);
        item = new itemPage(driver, wait);
        log.loginAs("standardUser");
    }

    @Test
    public void verifyProductListIsDisplayed() {

        log("Starting test: Verify Product List Is Displayed");

        assertThat(item.productsInventory.isDisplayed()).describedAs("Products inventory is NOT displayed").isTrue();
        if (item.productsInventory.isDisplayed()) {
            List<WebElement> products = item.productList;
            assertThat(products.size()).describedAs("Product list should have products displayed").isGreaterThan(0);
        }
        log("Product List Is Displayed with " + item.productList.size() + " products");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
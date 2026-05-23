package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.WebElement;

public class PRD003_VerifyProductNameIsDisplayed extends BaseScript {

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
    public void VerifyProductNameIsDisplayed() {

        log("Starting test: Verify Product Name Is Displayed");

        assertThat(item.productsInventory.isDisplayed()).describedAs("Products inventory is NOT displayed").isTrue();
        if (item.productsInventory.isDisplayed()) {
            List<WebElement> productName = item.productName;
            assertThat(productName.size()).describedAs("Product name is NOT displayed").isGreaterThan(0);
            productName.forEach(name -> log("Product Name: " + name.getText()));
        }
        log("Product Name Is Displayed with " + item.productName.size() + " products");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
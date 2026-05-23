package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.WebElement;

public class PRD004_Verify_ProductPriceIsDisplayed extends BaseScript {

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
    public void VerifyProductPriceIsDisplayed() {

        log("Starting test: Verify Product Price Is Displayed");

        List<WebElement> productNames = item.productName;
        List<WebElement> productPrices = item.productPrice;

        assertThat(productNames)
                .describedAs("Product names should be displayed")
                .isNotEmpty();

        assertThat(productPrices)
                .describedAs("Product prices should be displayed")
                .isNotEmpty();

        assertThat(productPrices.size())
                .describedAs("Each product name must have a corresponding price")
                .isEqualTo(productNames.size());

        for (int i = 0; i < productNames.size(); i++) {
            String name = productNames.get(i).getText();
            String price = productPrices.get(i).getText();

            assertThat(name)
                    .describedAs("Product name at index " + i)
                    .isNotBlank();

            assertThat(price)
                    .describedAs("Product price at index " + i)
                    .isNotBlank();

            log("Product " + (i + 1) + ": " + name + " - " + price);
        }

        log("All " + productNames.size() + " products have names AND prices");

    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
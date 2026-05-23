package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.WebElement;

public class PRD005_VerifyProductImageIsDisplayed extends BaseScript {

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
    public void VerifyProductImageIsDisplayed() {

        log("Starting test: Verify Product Image Is Displayed");

        List<WebElement> productNames = item.productName;
        List<WebElement> productImages = item.productImage;

        for (int i = 0; i < productNames.size(); i++) {
            String name = productNames.get(i).getText();

            assertThat(name)
                    .describedAs("Product name at index " + i)
                    .isNotBlank();

            assertThat(productImages.get(i).isDisplayed())
                    .describedAs("Product image at index " + i)
                    .isTrue();

            log("Product " + (i + 1) + ": " + name + " - " + productImages.get(i).getAttribute("src")
                    + " is displayed");
        }

        log("All " + productNames.size() + " products have names AND images");

    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
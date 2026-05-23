package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PRD001_VerifyProductsPageIsDisplayedAfterLogin extends BaseScript {

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
    public void verifyProductsPageIsDisplayedAfterLogin() {

        log("Starting test: Verify Products Page Is Displayed After Login");

        assertThat(item.productsInventory.isDisplayed()).describedAs("Products inventory is NOT displayed").isTrue();
        log("Products inventory is displayed");

        log("Products Page Is Displayed After Login");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
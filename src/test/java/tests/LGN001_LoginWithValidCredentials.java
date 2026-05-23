package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LGN001_LoginWithValidCredentials extends BaseScript {

    loginFlow loginFlow;
    itemPage item;

    @BeforeMethod
    public void start() {

        setUp();

        loginFlow = new loginFlow(driver, wait);
        item = new itemPage(driver, wait);
    }

    @Test
    public void loginWithValidCredentials() {

        log("Starting test: Login with valid credentials");

        loginFlow.loginAs("standardUser");

        log("Validating successful login");

        assertThat(item.appLogo.isDisplayed()).describedAs("App logo is NOT displayed").isTrue();

        log("Login successful");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
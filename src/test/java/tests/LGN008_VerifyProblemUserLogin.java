package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;
import pages.loginPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LGN008_VerifyProblemUserLogin extends BaseScript {

    loginFlow loginFlow;
    loginPage login;
    itemPage itemPage;

    @BeforeMethod
    public void start() {

        setUp();

        loginFlow = new loginFlow(driver, wait);
        login = new loginPage(driver, wait);
        itemPage = new itemPage(driver, wait);
    }

    @Test
    public void VerifyProblemUserLogin() {

        log("Starting test: Verify problem user login");

        loginFlow.loginAs("problemUser");
        assertThat(itemPage.appLogo.isDisplayed()).describedAs("App logo is NOT displayed").isTrue();
        log("Login successful");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
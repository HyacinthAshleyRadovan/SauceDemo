package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LGN009_VerifyPerformanceGlitchUserLogin extends BaseScript {

    loginFlow loginFlow;
    itemPage itemPage;

    @BeforeMethod
    public void start() {

        setUp();

        loginFlow = new loginFlow(driver, wait);
        itemPage = new itemPage(driver, wait);
    }

    @Test
    public void verifyPerformanceGlitchUserLogin() {

        log("Starting test: Verify performance glitch user login");

        loginFlow.loginAs("performanceGlitchUser");

        assertThat(itemPage.appLogo.isDisplayed())
                .describedAs("App logo is NOT displayed")
                .isTrue();

        log("Login successful");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
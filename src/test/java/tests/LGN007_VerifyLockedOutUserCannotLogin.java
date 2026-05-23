package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.loginPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LGN007_VerifyLockedOutUserCannotLogin extends BaseScript {

    loginFlow loginFlow;
    loginPage login;

    @BeforeMethod
    public void start() {

        setUp();

        loginFlow = new loginFlow(driver, wait);
        login = new loginPage(driver, wait);
    }

    @Test
    public void VerifyLockedOutUserCannotLogin() {

        log("Starting test: Verify locked out user cannot login");

        loginFlow.loginAs("lockedOutUser");
        assertThat(login.errorMessage.getText()).contains("Epic sadface: Sorry, this user has been locked out.");
        log("Error message " + login.errorMessage.getText() + " is displayed");

        log("Login failed as expected");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
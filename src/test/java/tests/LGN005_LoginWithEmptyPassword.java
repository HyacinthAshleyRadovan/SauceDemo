package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;
import pages.loginPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LGN005_LoginWithEmptyPassword extends BaseScript {

    loginFlow loginFlow;
    loginPage login;

    @BeforeMethod
    public void start() {

        setUp();

        loginFlow = new loginFlow(driver, wait);
        login = new loginPage(driver, wait);
    }

    @Test
    public void loginWithEmptyPassword() {

        log("Starting test: Login with empty password");

        loginFlow.login("standard_user", "");
        assertThat(login.errorMessage.isDisplayed()).isTrue();
        log("Error message " + login.errorMessage.getText() + " is displayed");
        log("Login failed as expected");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
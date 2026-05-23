package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;
import pages.loginPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LGN006_LoginWithEmptyUsernameAndPassword extends BaseScript {

    loginFlow loginFlow;
    loginPage login;

    @BeforeMethod
    public void start() {

        setUp();

        loginFlow = new loginFlow(driver, wait);
        login = new loginPage(driver, wait);
    }

    @Test
    public void loginWithEmptyUsernameAndPassword() {

        log("Starting test: Login with empty username and password");

        loginFlow.login("", "");
        assertThat(login.errorMessage.isDisplayed()).isTrue();
        assertThat(login.errorMessage.getText()).contains("Epic sadface: Username is required");

        log("Login failed as expected");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
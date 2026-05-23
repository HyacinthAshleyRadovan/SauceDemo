package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;
import pages.loginPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LGN002_LoginWithInvalidPassword extends BaseScript {

    loginFlow loginFlow;
    loginPage login;

    @BeforeMethod
    public void start() {

        setUp();

        loginFlow = new loginFlow(driver, wait);
        login = new loginPage(driver, wait);
    }

    @Test
    public void loginWithInvalidPassword() {

        log("Starting test: Login with invalid credentials");

        loginFlow.login("standard_user", "invalid_password");
        assertThat(login.errorMessage.getText())
                .contains("Epic sadface: Username and password do not match any user in this service");
        log("Error message " + login.errorMessage.getText() + " is displayed");
        log("Login failed as expected");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
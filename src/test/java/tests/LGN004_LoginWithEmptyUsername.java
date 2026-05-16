package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;
import pages.loginPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LGN004_LoginWithEmptyUsername extends BaseScript {

    loginFlow loginFlow;
    loginPage login;

    @BeforeMethod
    public void start() {

        setUp();

        loginFlow = new loginFlow(driver, wait);
        login = new loginPage(driver, wait);
    }

    @Test
    public void loginWithEmptyUsername() {

        log("Starting test: Login with empty username");

        loginFlow.login("", "secret_sauce");
        assertThat(login.errorMessage.isDisplayed()).isTrue();
        log("Error message " + login.errorMessage.getText() + " is displayed");
        log("Login failed as expected");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
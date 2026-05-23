package tests;

import base.BaseScript;
import pages.loginPage;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LGN010_VerifyPasswordMasking extends BaseScript {

    loginPage login;

    @BeforeMethod
    public void start() {
        setUp();
        login = new loginPage(driver, wait);
    }

    @Test
    public void verifyPasswordMasking() {

        log("Starting test: Verify password masking");

        type(login.passwordInput, "secret_sauce");

        assertThat(login.passwordInput.getAttribute("type"))
                .describedAs("Password input is NOT masked")
                .isEqualTo("password");

        log("Password masking verified");
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
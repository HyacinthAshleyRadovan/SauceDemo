package tests;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import utils.jsonReader;
import base.BaseScript;
import pages.itemPage;
import pages.loginPage;

public class LogIn extends BaseScript {

    @BeforeMethod
    public void start() {
        setUp();
    }

    @Test
    public void loginTest() {

        loginPage login = new loginPage(driver);
        itemPage item = new itemPage(driver);

        String path = "src/test/java/data/logInData.json";

        JSONObject data = jsonReader.getJsonData(path);

        String username = data.getJSONObject("validUser").getString("username");
        String password = data.getJSONObject("validUser").getString("password");

        type(login.usernameInput, username);
        assertThat(login.usernameInput.getAttribute("value")).describedAs("Username NOT matched").isEqualTo(username);
        log.info("Input username");

        type(login.passwordInput, password);
        log.info("Input password");

        click(login.loginBtn);
        log.info("Clicked submit button");

        assertThat(item.appLogo.isDisplayed()).describedAs("App Logo is NOT displayed").isTrue();
        log.info("App Logo is displayed");

        System.out.println("SYSTEM OUT");
        log("LOG TEST");

    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
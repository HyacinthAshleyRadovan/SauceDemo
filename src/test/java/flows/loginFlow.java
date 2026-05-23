package flows;

import java.util.concurrent.TimeoutException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseScript;
import pages.loginPage;
import utils.jsonReader;

public class loginFlow extends BaseScript {

    loginPage loginPage;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public loginFlow(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        loginPage = new loginPage(driver, wait);
    }

    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    public void loginAs(String userType) {
        JSONObject users = jsonReader.getJsonData("data/loginData.json");
        JSONObject user = users.getJSONObject(userType);

        loginPage.login(
                user.getString("username"),
                user.getString("password"));

        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
        log("Pressed ESC to dismiss popup");
    }
}
package tests;

import base.BaseScript;
import flows.loginFlow;
import pages.itemPage;
import pages.loginPage;
import actions.productActions;

import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PRD010_VerifyLogoutFunctionality extends BaseScript {

    loginFlow log;
    loginPage login;
    itemPage item;
    productActions prodAct;

    @BeforeMethod
    public void start() {
        setUp();
        log = new loginFlow(driver, wait);
        prodAct = new productActions(driver);
        item = new itemPage(driver, wait);
        login = new loginPage(driver, wait);
        log.loginAs("standardUser");
    }

    @Test
    public void VerifyLogoutFunctionality() {

        log("Starting test: Verify Logout Functionality");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        assertThat(item.menuBtn.isDisplayed()).describedAs("Menu Button is NOT displayed").isTrue();
        js.executeScript("arguments[0].click();", item.menuBtn);
        log("Menu button clicked");

        assertThat(prodAct.getDynamicMenuOption("Logout").isDisplayed()).describedAs("Logout option is NOT displayed")
                .isTrue();
        js.executeScript("arguments[0].click();", prodAct.getDynamicMenuOption("Logout"));

        assertThat(login.loginForm.isDisplayed()).describedAs("Login form is NOT displayed after logout").isTrue();
        log("Logout functionality verified successfully");

    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}
package flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.loginPage;

public class loginFlow {

    loginPage loginPage;

    public loginFlow(WebDriver driver, WebDriverWait wait) {
        loginPage = new loginPage(driver, wait);
    }

    public void login(String username, String password) {

        loginPage.login(username, password);
    }

    public void loginAsStandardUser() {
        loginPage.login("standard_user", "secret_sauce");
    }

    public void loginAsLockedOutUser() {
        loginPage.login("locked_out_user", "secret_sauce");
    }

    public void loginAsProblemUser() {
        loginPage.login("problem_user", "secret_sauce");
    }
}
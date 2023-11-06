package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest extends AbstractBaseTest {
    private final String demoQALoginURL = "https://demoqa.com/login";

    @DataProvider
    public Object[][] users(Method m) {
        switch (m.getName()) {
            case "checkHappyPathLogin":
                return new Object[][]{{"tatiana77moskvina", "Qwe12345!"}};
            case "checkInvalidUserOrPwd":
                return new Object[][]{{"InvalidUser098", "123"}};
            case "checkPasswordWithSpace":
                return new Object[][]{{"SpaceUser00", "   "}};
        }
        return null;

    }


    @BeforeMethod
    public void openUrl() {
        open(demoQALoginURL);
    }

    @Test(dataProvider = "users", priority = 5)
    public void checkHappyPathLogin(String login, String password) {
        loginPage.fillInputLogin(login);
        loginPage.fillInputPassword(password);
        loginPage.clickLoginButton();
        profilePage.checkUserIsLoggedIn(login);
    }

    @Test(priority = 1)
    public void checkEmptyFieldUserName() {
        loginPage.clickLoginButton();
        loginPage.checkEmptyFieldUserName();
    }

    @Test(priority = 2)
    public void checkEmptyFieldPassword() {
        loginPage.clickLoginButton();
        loginPage.checkEmptyFieldPassword();
    }

    @Test(dataProvider = "users", priority = 3)
    public void checkInvalidUserOrPwd(String userName, String password) {
        loginPage.fillInputLogin(userName);
        loginPage.fillInputPassword(password);
        loginPage.clickLoginButton();
        loginPage.checkAlertInvalidValues();
    }

    @Test(dataProvider = "users", priority = 4)
    public void checkPasswordWithSpace(String userName, String password) {
        loginPage.fillInputLogin(userName);
        loginPage.fillInputPassword(password);
        loginPage.clickLoginButton();
        loginPage.checkAlertInvalidValues();
    }
}

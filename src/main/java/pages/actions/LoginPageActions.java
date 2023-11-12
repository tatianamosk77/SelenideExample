package pages.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import org.testng.Assert;
import pages.locators.LoginPageLocators;

public class LoginPageActions extends LoginPageLocators {

    @Step
    public void fillInputLogin(String login) {
        fieldLogin.sendKeys(login);
        CustomLogger.logger.info(String.format("The login %s was filled out", login));
    }

    @Step
    public void fillInputPassword(String password) {
        fieldPassword.sendKeys(password);
        CustomLogger.logger.info(String.format("The password %s was filled out", password));
    }

    @Step
    public void clickLoginButton() {
        loginButton.click();
        CustomLogger.logger.info("Login button was clicked");
    }

    @Step
    public void checkEmptyFieldUserName() {
        Assert.assertTrue(fieldLogin.getAttribute("class").contains("is-invalid"), "Empty field 'UserName' isn't red");
        CustomLogger.logger.info("Empty field 'UserName' is red - ok");
    }
    @Step
    public void checkEmptyFieldPassword() {
        Assert.assertTrue(fieldPassword.getAttribute("class").contains("is-invalid"), "Empty field 'Password' isn't red");
        CustomLogger.logger.info("Empty field 'Password' is red - ok");
    }

    @Step
    public void checkAlertInvalidValues(){
        Assert.assertEquals(invalidValuesAlert.getText(), "Invalid username or password!");
        CustomLogger.logger.info("OK");
    }

}

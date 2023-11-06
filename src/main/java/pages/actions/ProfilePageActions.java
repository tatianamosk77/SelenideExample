package pages.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import org.testng.Assert;
import pages.locators.ProfilePageLocators;

import static helper.CommonSteps.getAndAttachScreenshot;

public class ProfilePageActions extends ProfilePageLocators {
    @Step
    public String getUserNameValue(){
       return userNameValue.getText();
    }

    @Step
    public void checkUserIsLoggedIn(String login){
        Assert.assertEquals(getUserNameValue(), login);
        getAndAttachScreenshot();
        CustomLogger.logger.info("OK");
    }
}

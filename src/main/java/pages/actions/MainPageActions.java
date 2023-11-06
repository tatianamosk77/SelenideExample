package pages.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.locators.MainPageLocators;

public class MainPageActions extends MainPageLocators {
    @Step
    public void clickBookAppButton(){
        bookApplicationButton.scrollTo();
        bookApplicationButton.click();
        CustomLogger.logger.info("OK");
    }
}

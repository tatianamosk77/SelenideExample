package pages.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

import org.testng.Assert;
import pages.locators.BookStorePageLocators;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BookStorePageActions extends BookStorePageLocators {
    private int amountOfSearchResults = 0;

    @Step
    public void clickLoginButton() {
        loginButton.click();
        CustomLogger.logger.info("OK");
    }

    @Step
    public void typeSearchWord(String word) {
        inputSearchBox.sendKeys(word);
    }

    @Step
    public void countOfResult() {
        amountOfSearchResults = $$(byXpath(searchResult)).size();
    }

    @Step
    public void checkSearchWordInResults(String word) {
        if (amountOfSearchResults != 0) {
            for (int i = 1; i <= amountOfSearchResults; i++) {
                Assert.assertTrue(containsIgnoreCase($(byXpath(searchResult + "[" + i + "]")).getText(), word),
                        "The word '" + word + "' wasn't found in result");
            }
        } else Assert.assertEquals(noDataInResult.getText(), "No rows found");
        CustomLogger.logger.info("OK");
    }
}

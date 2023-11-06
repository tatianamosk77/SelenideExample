package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePageLocators {
    protected SelenideElement userNameValue = $(byXpath("//label[@id='userName-value']"));
}

package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageLocators {
    protected SelenideElement bookApplicationButton = $(byXpath("//h5[text()='Book Store Application']"));

}

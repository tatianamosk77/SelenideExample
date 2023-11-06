package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selectors.byXpath;

public class LoginPageLocators {
    protected SelenideElement fieldLogin = $(byXpath("//input[@id='userName']"));
    protected SelenideElement fieldPassword = $(byXpath("//input[@id='password']"));
    protected SelenideElement loginButton = $(byXpath("//button[@id='login']"));
    protected SelenideElement invalidValuesAlert = $(byXpath("//div/p[@id='name']"));
}

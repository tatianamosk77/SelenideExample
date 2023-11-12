package pages.locators;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BookStorePageLocators {
    protected SelenideElement loginButton = $(byXpath("//button[@id='login']"));
    protected String searchResult = "(//div[@class='action-buttons'])";
    protected  SelenideElement inputSearchBox = $(byXpath("//input[@id='searchBox']"));
    protected  SelenideElement noDataInResult = $(byXpath("//div[@class='rt-noData']"));

}

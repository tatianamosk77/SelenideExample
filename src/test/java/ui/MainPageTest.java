package ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static helper.CommonSteps.checkUrl;

public class MainPageTest extends AbstractBaseTest{
    private final String demoQAMainURL = "https://demoqa.com";

    @BeforeMethod
    public void openUrl() {
        open(demoQAMainURL);
    }
    @Test
    public void checkBookAppURL(){
        mainPage.clickBookAppButton();
        checkUrl("https://demoqa.com/books", 5);
    }
}

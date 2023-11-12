package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;

import static com.codeborne.selenide.Selenide.open;
import static helper.CommonSteps.checkUrl;
import static helper.CsvHelper.parseCsv;

public class BookStorePageTest extends AbstractBaseTest {
    private final String demoQABookURL = "https://demoqa.com/books";
    private final String csvPath = "src/test/resources/searchWords.csv";


    @DataProvider
    public Iterator<Object[]> searchWords() throws IOException {
        return parseCsv(csvPath);
    }

    @BeforeMethod
    public void openUrl() {
        open(demoQABookURL);
    }

    @Test
    public void checkLoginURL() {
        bookStorePage.clickLoginButton();
        checkUrl("https://demoqa.com/login", 5);
    }

    @Test(dataProvider = "searchWords")
    public void checkSearchResult(String word) {
        bookStorePage.typeSearchWord(word);
        bookStorePage.countOfResult();
        bookStorePage.checkSearchWordInResults(word);
    }
}

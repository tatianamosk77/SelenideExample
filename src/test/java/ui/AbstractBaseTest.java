package ui;

import config.RunnerConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.actions.BookStorePageActions;
import pages.actions.LoginPageActions;
import pages.actions.MainPageActions;
import pages.actions.ProfilePageActions;

public abstract class AbstractBaseTest {
    private final RunnerConfig config = new RunnerConfig();
    public LoginPageActions loginPage = new LoginPageActions();
    public ProfilePageActions profilePage = new ProfilePageActions();
    public MainPageActions mainPage = new MainPageActions();
    public BookStorePageActions bookStorePage = new BookStorePageActions();


    @BeforeClass
    @Parameters({"projectId", "browser", "browserVersion"})
    public void setUp(
            @Optional("Demo QA") String projectId,
            @Optional("Chrome") String browser,
            @Optional("117") String browserVersion
    ) {
        config.setUpConfig(projectId, browser, browserVersion);
    }
}

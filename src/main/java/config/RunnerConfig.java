package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import logger.CustomLogger;

import static global.Global.useSelenoid;

public class RunnerConfig {

    @Step
    public void setUpConfig(
            String projectId,
            String browser,
            String browserVersion
    ) {
        System.out.println("projectId: " + projectId);
        System.out.println("browser: " + browser);
        System.out.println("browserVersion: " + browserVersion);
        Configuration.pageLoadTimeout = 80000;
        Configuration.downloadsFolder = "target/build/downloads";
        Configuration.reportsFolder = "target/screenshots";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.pageLoadStrategy = "eager";

        if (useSelenoid) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            CustomLogger.logger.info("Selenoid is used");

//            Configuration.browserCapabilities.setCapability("enableVNC", false);
//            Configuration.browserCapabilities.setCapability("enableVideo", false);
        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        CustomLogger.logger.info("OK");
    }
}

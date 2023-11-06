package helper;

import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import logger.CustomLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CommonSteps {
    private static final SelenideElement bodyOfPageWithIP = $(byXpath("//body"));
    private static final SelenideElement fieldCountryValue = $(byXpath("//tr[@id='/country']" +
            "/td[@class='treeValueCell stringCell']/span"));
    private static final String url = "https://ipinfo.io/json";

    @Step
    public static String getCountryCodeByIpFirefox() {
        open(url);
        sleep(1000);
        return fieldCountryValue.getText().replace("\"", "");
    }

    @Step
    public static String getCountryCodeByIp(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            return getCountryCodeByIpChrome();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            return getCountryCodeByIpFirefox();
        }
        return null;
    }

    @Step
    public static String getCountryCodeByIpChrome() {
        ObjectMapper objectMapper = new ObjectMapper();
        open(url);
        sleep(1000);
        String response = bodyOfPageWithIP.getText();
        JsonNode responseAsJsonObject = null;
        try {
            responseAsJsonObject = objectMapper.readTree(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String countryCode = Objects.requireNonNull(responseAsJsonObject).get("country").textValue();
        CustomLogger.logger.info(countryCode);
        return countryCode;
    }

   /* @Step
    public static void checkGeoLocationInBrowser(String country) {
        String countryCode = "";
        for (int i = 0; i < 20; i++) {
            try {
                countryCode = getCountryCodeByIp();
                if (countryCode != null) {
                    break;
                }
            } catch (WebDriverException e) {
                Selenide.closeWebDriver();
                sleep(5000);
                countryCode = getCountryCodeByIp();
            }
        }
        getAndAttachScreenshot();
        if (countryCode != null && countryCode.equals(country)) {
            CustomLogger.logger.info("Test geolocation by ip passed: " + countryCode + " equals " + country);
        } else {
            if (country != null && !country.isEmpty()) {
                Assert.fail("Test geolocation by ip failed: " + countryCode + " not equals " + country + "\n" +
                        bodyOfPageWithIP.getText());
            } else {
                CustomLogger.logger.info(bodyOfPageWithIP.getText());
            }
        }
    }*/

    @Step
    public static void checkUrl(String mustContains, int timeOutSec) {
        boolean testPassed = false;
        for (int i = 0; i < timeOutSec * 2; i++) {
            if (url().contains(mustContains)) {
                testPassed = true;
                getAndAttachScreenshot();
                break;
            } else {
                sleep(500);
            }
        }
        if (!testPassed) {
            getAndAttachScreenshot();
            Assert.fail("Actual URL: " + url() + "\n" + "Expected URL: " + mustContains);
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] getAndAttachScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

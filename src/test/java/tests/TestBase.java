package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeEach
    void addListenerToContainStepByStepInformationInAllureReport() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    static void applyingBrowserConfigurations() {
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion", "127.0");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        String selenoidUrl = System.getProperty("selenoidUrl", "selenoid.autotests.cloud/wd/hub"); //    https://user1:1234@selenoid.autotests.cloud/wd/hub
        String enableVNC = System.getProperty("enableVNC", "true");
        String enableVideo = System.getProperty("enableVideo", "true");

        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", enableVNC,
                "enableVideo", enableVideo
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = selenoidUrl;
    }

    @AfterEach
    void addAttachmentsForAllureReport() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

}
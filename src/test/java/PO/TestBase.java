package PO;

import Attach.Attachments;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.browser = System.getProperty("browser");
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.browserVersion = System.getProperty("browserVersion", "126");
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@" + System.getProperty("remoteHost") + "/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true

        ));
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void logger(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
        void getAttach(){
        Attachments.screenshotAs("Screen after each");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        Selenide.closeWebDriver();
    }
}

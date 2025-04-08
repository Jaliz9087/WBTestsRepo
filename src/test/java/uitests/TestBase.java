package uitests;

import attach.Attachments;
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
        Configuration.timeout = 70000;
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.pageLoadTimeout = 50000;
        Configuration.pageLoadStrategy = "eager";

        Configuration.remote = "https://user1:1234@" + System.getProperty("remoteHost") + "/wd/hub";
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browserVersion");

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
        Selenide.executeJavaScript(
                "const closeElements = document.querySelectorAll(" +
                        "  '[id*=\"cookie\"], [class*=\"cookie\"], [class*=\"consent\"], [id*=\"consent\"], [class*=\"banner\"], [class*=\"popup\"], [id*=\"popup\"]'" +
                        ");" +
                        "closeElements.forEach(e => e.style.display = 'none');" +
                        "const acceptBtn = [...document.querySelectorAll('button, input[type=button]')].find(e => /принять|accept|agree/i.test(e.innerText));" +
                        "if (acceptBtn) acceptBtn.click();"
        );
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
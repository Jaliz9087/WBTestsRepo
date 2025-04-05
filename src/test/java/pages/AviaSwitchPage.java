package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AviaSwitchPage {
    public SelenideElement Avia = $(By.xpath("//a[text()='Авиабилеты']"));
    @Step("Открыть авиа страницу")
    public AviaSwitchPage openAviaPage() {
        Avia.click();
        return this;
    }


}

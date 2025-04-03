package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AviaSwitchPage {
    public SelenideElement Avia = $(By.xpath("//a[text()='Авиабилеты']")),
            result = $(".layout-header-right_bottomRow__e9nxd");
    @Step("Открыть авиа страницу")
    public AviaSwitchPage openAviaPage() {
        Avia.click();
        return this;
    }
    @Step("Смотрим результат")
    public AviaSwitchPage result(String value) {
        result.shouldHave(text(value));
        return this;
    }

}

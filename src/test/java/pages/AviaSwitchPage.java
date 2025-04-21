package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class AviaSwitchPage {
    public SelenideElement Avia = $("a[href='/travel?entry_point=tab_header']"),
    Res = $(".selector-form_buttonAviaTickets__Zw_ml");

    @Step("Открыть авиа страницу")
    public AviaSwitchPage openAviaPage() {
        Avia.click();
        return this;
    }
    @Step("Проверяем переход")
    public AviaSwitchPage checkResult(String value) {
        Res.shouldHave(text(value));
        return this;

    }


}

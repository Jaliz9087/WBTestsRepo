package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AviaSwitchPage {
    public SelenideElement Avia = $(".simple-menu__switch-item j-avia"),
    result=$(".layout-main_main__Q8_H0");
    @Step("Открыть авиа страницу")
    public AviaSwitchPage openAviaPage() {
        Avia.click();
        return this;
    }
    @Step("Смотрим результат")
    public AviaSwitchPage result() {
        result.shouldHave(text("Популярные направления"));
        return this;
    }

}

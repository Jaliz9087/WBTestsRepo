package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Currency {
    public SelenideElement curButt = $(".simple-menu__link--country"),
            bynButt = $(".radio-with-text:nth-child(9) .radio-with-text__name"),
            checkCurr = $(".simple-menu__currency");

    @Step("Кликаем по кнопке смены валюты")
    public Currency clickCurrencyButton(){
        curButt.click();
        sleep(4000);
        return this;
    }
    @Step("Выбираем БУНы")
    public Currency selectCurrency(){
        bynButt.click();
        return this;
    }
    @Step("Проверяем что БУНы выбрались")
    public Currency checkCurrencyResult(String value){
        checkCurr.shouldHave(text(value));

        return this;
    }
}

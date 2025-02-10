package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Basket {
    public SelenideElement resultBasket = $(".good-info__good-name");

    @Step("Проверяем что добавилось в корзину")
    public Basket basketResult(String value){
        resultBasket.shouldHave(text(value));
        return this;
    }
}

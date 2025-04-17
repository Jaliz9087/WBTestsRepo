package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.impl.Html.text;

public class CardPage {
    public SelenideElement basketDrop = $(".product-page__order-buttons > div:nth-child(2) > div:nth-child(6) > div:nth-child(1) > button:nth-child(7)"),
            clickBasket = $(".navbar-pc__icon--basket"),
            basketRes=$(".good-info__title");

    @Step("Кликаем по кнопке дропа в корзину")
    public CardPage dropToBasket (){
        basketDrop.click();
        return this;
    }
    @Step("Кликаем по кнопке 'Коризна'")
    public CardPage basketClick(){
        clickBasket.click();
        return this;
    }
    @Step("Проверяем корзину на наличие айфона")
    public CardPage basketResult(String value){
        basketRes.shouldHave(text(value));
        return this;
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CardPage {
    public SelenideElement basketDrop = $(".product-page__order-buttons"),
            clickBasket = $(".navbar-pc__icon--basket");

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
}

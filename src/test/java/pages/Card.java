package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Card {
    public SelenideElement basketDrop = $(".product-page__order-buttons"),
            clickBasket = $(".navbar-pc__icon--basket");

    public Card dropToBasket (){
        basketDrop.click();
        return this;
    }
    public Card basketClick(){
        clickBasket.click();
        return this;
    }
}

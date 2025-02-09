package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Basket {
    public SelenideElement resultBasket = $(".good-info__good-name");
    public Basket basketResult(String value){
        resultBasket.shouldHave(text(value));
        return this;
    }
}

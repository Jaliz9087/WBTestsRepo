package PO;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPagePO {
    public SelenideElement loginPageClick =  $("a[href=\"/security/login?returnUrl=https%3A%2F%2Fwww.wildberries.ru%2F\"]"),
    inputNumber = $(".input-item"),
    checkError = $(".j-error-full-phone"),
    setGoods = $("#searchInput"),
    clickFlipperCard = $(".product-card__wrapper"),
    resultsOurSearch=$(".searching-results__inner"),
    basketDrop = $(".product-page__order-buttons"),
    clickBasket = $(".navbar-pc__icon--basket"),
    resultBasket = $(".good-info__good-name");

    public MainPagePO openPage(){
        open("https://www.wildberries.ru/");
        return this;
    }

    public MainPagePO loginClick (){
        loginPageClick.click();
        return this;
    }
    public MainPagePO inputNum(String value ){
        inputNumber.setValue(value).pressEnter();
        return  this;
    }
    public MainPagePO Error(){
        checkError.shouldHave(text("Некорректный формат номера"));
        return this;

    }
    //2ndTest
    public MainPagePO setOurGoods(String value){
        setGoods.setValue(value).pressEnter();
        return this;
    }

    public MainPagePO resultsCheck(String value){
        resultsOurSearch.shouldHave(text(value));
        return this;
    }
    public MainPagePO clickGoodsCard(String value){
        clickFlipperCard.scrollIntoView(true).shouldHave(text(value)).click();
        return this;
    }
    public MainPagePO dropToBasket (){
        basketDrop.click();
        return this;
    }
    public MainPagePO basketClick(){
        clickBasket.click();
        return this;
    }
    public MainPagePO basketResult(String value){
        resultBasket.shouldHave(text(value));
        return this;
    }
}

package PO;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MainPagePO {
    public SelenideElement loginPageClick =  $("a[href=\"/security/login?returnUrl=https%3A%2F%2Fwww.wildberries.ru%2F\"]"),
    inputNumber = $(".input-item"),
    checkError = $(".j-error-full-phone"),
    setGoods = $("#searchInput"),
    clickFlipperCard = $(".product-card__wrapper"),
    resultsOurSearch=$(".searching-results__inner"),
    basketDrop = $(".product-page__order-buttons"),
    clickBasket = $(".navbar-pc__icon--basket"),
    resultBasket = $(".good-info__good-name"),
    openMenu = $(".nav-element__burger-line"),
    sert = $("a[href=\"/gift/certificates\"]"),
    curButt = $(".simple-menu__link--country"),
    bynButt = $(".radio-with-text:nth-child(9) .radio-with-text__name"),
    checkCurr = $(".simple-menu__currency"),
    address = $(By.linkText("Адреса")),
    inpAdd = $(".map-search__input"),
    listAdd = $(".map-search__suggest-list");

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
    public MainPagePO openBurgMenu(){
        openMenu.click();
        return this;
    }
    public MainPagePO checkSert(String value){
        sert.shouldHave(text(value));
        return this;
    }
    public MainPagePO clickCurrencyButton(){
        curButt.click();
        sleep(8000);
        return this;
    }
    public MainPagePO selectCurrency(){
        bynButt.click();
        return this;
    }
    public MainPagePO checkCurrencyResult(String value){
        checkCurr.shouldHave(text(value));

        return this;
    }
    public MainPagePO clickAddressButton(){
        address.click();
        sleep(7000);//карту грузит долго поэтому слип
        return this;
    }
    public MainPagePO inputAddress(String value){
        inpAdd.scrollIntoView(true).setValue(value);
        return this;
    }
    public MainPagePO checkListOfAddress(String value){
        listAdd.shouldHave(text(value));

        return this;
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchGoods {
    public SelenideElement setGoods = $("#searchInput"),
            clickFlipperCard = $(".product-card__wrapper"),
            resultsOurSearch=$(".searching-results__inner");


    public SearchGoods setOurGoods(String value){
        sleep(7000);
        setGoods.setValue(value).pressEnter();
        return this;
    }

    public SearchGoods resultsCheck(String value){
        resultsOurSearch.shouldHave(text(value));
        return this;
    }
    public SearchGoods clickGoodsCard(String value){
        clickFlipperCard.scrollIntoView(true).shouldHave(text(value)).click();
        return this;
    }
}

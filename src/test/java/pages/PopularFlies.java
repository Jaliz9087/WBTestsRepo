package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PopularFlies {
    public SelenideElement Flies = $(".block-directions_container__DGyXq");
    @Step("Скролим до популярных рейсов")
    public PopularFlies ScrollToFlies(){
        Flies.scrollIntoView(false);
        return this;
    }
    @Step("Чекаем популярные рейсы")
    public PopularFlies resultCh(){
        Flies.shouldHave(text("Санкт-Петербург"));
        return this;
    }


}

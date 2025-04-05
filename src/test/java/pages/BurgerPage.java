package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BurgerPage {
    public SelenideElement openMenu = $(".nav-element__burger-line"),
            sert = $("a[href=\"/gift/certificates\"]");

    @Step("Кликаем по кнопке бургер-меню")
    public BurgerPage openBurgMenu(){
        sleep(7000);
        openMenu.click();
        return this;
    }
    @Step("Проверяем наличие сертификатов")
    public BurgerPage checkSert(String value){
        sert.shouldHave(text(value));
        return this;
    }
}

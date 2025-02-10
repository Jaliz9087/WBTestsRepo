package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Address {
    public SelenideElement
            address = $(By.linkText("Адреса")),
            inpAdd = $(".map-search__input"),
            listAdd = $(".map-search__suggest-list");

    @Step("Кликаем по кнокпе 'Адреса'")
    public Address clickAddressButton(){
        address.click();
        sleep(7000);//карту грузит долго поэтому слип
        return this;
    }
    @Step("Вводим адресс")
    public Address inputAddress(String value){
        inpAdd.scrollIntoView(true).setValue(value);
        return this;
    }
    @Step("Проверяем лист адресов")
    public Address checkListOfAddress(String value){
        listAdd.shouldHave(text(value));

        return this;
    }
}

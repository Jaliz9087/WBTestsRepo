package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage {
    public SelenideElement loginPageClick =  $("a[href=\"/security/login?returnUrl=https%3A%2F%2Fwww.wildberries.ru%2F\"]"),
            inputNumber = $(".input-item"),
            checkError = $(".j-error-full-phone");
    @Step("Кликаем по кнопки логина")
    public LoginPage loginClick (){
        sleep(7000);
        loginPageClick.click();
        return this;
    }
    @Step("Вводим невалидный номер и прожимаем enter")
    public LoginPage inputNum(String value ){
        inputNumber.setValue(value).pressEnter();
        return  this;
    }
    @Step("Проверяем получение ошибки")
    public LoginPage error(String value){
        checkError.shouldHave(text(value));
        return this;

    }

}

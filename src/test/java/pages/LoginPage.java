package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage {
    public SelenideElement loginPageClick =  $("a[href=\"/security/login?returnUrl=https%3A%2F%2Fwww.wildberries.ru%2F\"]"),
            inputNumber = $(".input-item"),
            checkError = $(".j-error-full-phone");

    public LoginPage loginClick (){
        sleep(7000);
        loginPageClick.click();
        return this;
    }
    public LoginPage inputNum(String value ){
        inputNumber.setValue(value).pressEnter();
        return  this;
    }
    public LoginPage Error(){
        checkError.shouldHave(text("Некорректный формат номера"));
        return this;

    }

}

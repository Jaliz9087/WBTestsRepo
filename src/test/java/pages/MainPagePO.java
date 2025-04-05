package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;


public class MainPagePO {
    @Step("Открываем главную страницу")
    public MainPagePO
    openPage() {
        open("https://www.wildberries.ru/");
        return this;
    }
    @Step("Открываем travel страницу")
    public MainPagePO
    openPageAvia() {
        open("https://www.wildberries.ru/travel");
        return this;
    }

}

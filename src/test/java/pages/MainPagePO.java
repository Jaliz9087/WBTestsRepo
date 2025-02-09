package pages;

import static com.codeborne.selenide.Selenide.*;


public class MainPagePO {
    public MainPagePO openPage() {
        open("https://www.wildberries.ru/");
        return this;
    }

}

package pages;

import com.codeborne.selenide.Selenide;
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
    public MainPagePO
      skipBanners(){
        Selenide.executeJavaScript(
                "const closeElements = document.querySelectorAll(" +
                        "  '[id*=\"cookie\"], [class*=\"cookie\"], [class*=\"consent\"], [id*=\"consent\"], [class*=\"banner\"], [class*=\"popup\"], [id*=\"popup\"]'" +
                        ");" +
                        "closeElements.forEach(e => e.style.display = 'none');" +
                        "const acceptBtn = [...document.querySelectorAll('button, input[type=button]')].find(e => /принять|accept|agree/i.test(e.innerText));" +
                        "if (acceptBtn) acceptBtn.click();");
        return this;

    }


}

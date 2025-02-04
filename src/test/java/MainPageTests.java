
import PO.MainPagePO;


import PO.TestBase;
import Utils.ForFaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static io.qameta.allure.Allure.step;

@Tag("AllTests")
public class MainPageTests extends TestBase {
    MainPagePO mainPagePO = new MainPagePO();
    ForFaker forFaker = new ForFaker();

    @Test
    @DisplayName("Получаем ошибку при вводе невалидного номера телефона")
    @Tag("NegativeTest")
    void failedLoginTest(){
        step("Откроем страницу и кликнем по логину", () ->{
            mainPagePO.openPage()
                    .loginClick();
        });
        step("Вводим невалидный номер", () ->{
            mainPagePO.inputNum(forFaker.UserNumber);
        });
        step("Проверяем получение ошибки", () ->{
            mainPagePO.Error();
        });
    }

   @Test
   @DisplayName("Search Dolphin n drop to basket =)")
   @Tag("SearchNBasket")
    void searchFlipperTest(){
        step("Откроем страницу", () ->{
            mainPagePO.openPage();
        });
        step("Ищем дельфина и проверяем полученный товар",() ->{
            mainPagePO.setOurGoods("Flipper Zero")
                    .resultsCheck("Flipper Zero")
                    .clickGoodsCard("Atlass");
        });
        step("Перекидываем товар в корзину", () ->{
            mainPagePO.dropToBasket()
                    .basketClick();
        });
        step("Проверяем корзину", () ->{
            mainPagePO.basketResult("Мультитул Flipper Zero");
        });

    }
    @ValueSource(strings = {
            "Сертификаты Wildberries"
    })
    @ParameterizedTest(name = "Смотрим серты в бургере ")
    @Tag("BurgerTest")
    void checkBrowserPage(String Check){
        step("Открыть бургер", () ->{
            mainPagePO.openPage()
                    .openBurgMenu();
        });
        step("Проверяем таб сертификатов", () ->{
             mainPagePO.checkSert(Check);
        });
    }

    @Test
    @Tag("Currency")
    @DisplayName("Switch currency")
    void franshizaTabTest(){
        step("Открываем страницу", () ->{
            mainPagePO.openPage();
        });
        step("Кликаем по валюте и выбираем буны", () ->{
            mainPagePO.clickCurrencyButton()
                    .selectCurrency();
        });
        step("Проверяем что выбрались БУНЫ", () ->{
            mainPagePO.checkCurrencyResult("BYN");
        });
    }

    @Test
    @Tag("MapTest")
    @DisplayName("Чекнем маппинг языка при вводе на латинице")
    void checkingLanguageMappingTest(){
        step("Открываем страницу и кликаем по адресам", () -> {
            mainPagePO.openPage()
                    .clickAddressButton();
        });
        step("Вводим адрес", () ->{
            mainPagePO.inputAddress("Jhlsyrf");
        });
        step("Проверяем лист адресов", () ->{
            mainPagePO.checkListOfAddress("улица Большая Ордынка");
        });
    }

}


import pages.*;


import utils.ForFaker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

@Tag("AllTests")
public class MainPageTests extends TestBase {
    MainPagePO mainPagePO = new MainPagePO();
    ForFaker forFaker = new ForFaker();
    LoginPage loginPage = new LoginPage();
    Address address = new Address();
    Basket basket = new Basket();
    Burger burger = new Burger();
    Card card = new Card();
    Currency currency = new Currency();
    SearchGoods searchGoods = new SearchGoods();

    @Test
    @DisplayName("Получаем ошибку при вводе невалидного номера телефона")
    @Tag("NegativeTest")
    void failedLoginTest(){
        step("Откроем страницу и кликнем по логину", () ->{
            mainPagePO.openPage();
            loginPage.loginClick();
        });
        step("Вводим невалидный номер", () ->{
            loginPage.inputNum(forFaker.UserNumber);
        });
        step("Проверяем получение ошибки", () ->{
            loginPage.Error();
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
            searchGoods.setOurGoods("Flipper Zero");
            searchGoods.resultsCheck("Flipper Zero");
            searchGoods.clickGoodsCard("Atlass");
        });
        step("Перекидываем товар в корзину", () ->{
            card.dropToBasket()
            .basketClick();
        });
        step("Проверяем корзину", () ->{
            basket.basketResult("Мультитул Flipper Zero");
        });

    }
    @ValueSource(strings = {
            "Сертификаты Wildberries"
    })
    @ParameterizedTest
    @DisplayName("Смотрим серты в бургере")
    @Tag("BurgerTest")
    void checkBrowserPageTest(String Check){
        step("Открыть бургер", () ->{
            mainPagePO.openPage();
            burger.openBurgMenu();
        });
        step("Проверяем таб сертификатов", () ->{
             burger.checkSert(Check);
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
            currency.clickCurrencyButton()
                    .selectCurrency();
        });
        step("Проверяем что выбрались БУНЫ", () ->{
            currency.checkCurrencyResult("BYN");
        });
    }

    @Test
    @Tag("MapTest")
    @DisplayName("Чекнем маппинг языка при вводе на латинице")
    void checkingLanguageMappingTest(){
        step("Открываем страницу и кликаем по адресам", () -> {
            mainPagePO.openPage();
            address.clickAddressButton();
        });
        step("Вводим адрес", () ->{
            address.inputAddress("Jhlsyrf");
        });
        step("Проверяем лист адресов", () ->{
            address.checkListOfAddress("улица Большая Ордынка");
        });
    }
}

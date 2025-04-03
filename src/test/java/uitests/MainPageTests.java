package uitests;

import io.qameta.allure.Owner;
import pages.*;
import utils.ForFaker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Owner("-whey-")
@Tags({@Tag("ui"), @Tag("AllTests")})
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
    AviaSwitchPage Aviasw = new AviaSwitchPage();
    PopularFlies popularFlies = new PopularFlies();





    @Test
    @DisplayName("Получаем ошибку при вводе невалидного номера")
    @Tag("NegativeTest")
    void failedLoginTest() {
        mainPagePO.openPage();
        loginPage.loginClick();
        loginPage.inputNum(forFaker.UserNumber);
        loginPage.Error();
    }

    @Test
    @DisplayName("Ищем iPhone и добавляем в корзину")
    @Tag("SearchNBasket")
    void searchFlipperTest() {
        mainPagePO.openPage();
        searchGoods.setOurGoods("iphone 16");
        searchGoods.resultsCheck("iPhone 16");
        searchGoods.clickGoodsCard("iPhone 16");
//        card.dropToBasket().basketClick();
//        basket.basketResult("iPhone 16");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Сертификаты Wildberries"})
    @DisplayName("Смотрим сертификаты")
    @Tag("BurgerTest")
    void checkBrowserPageTest(String check) {
        mainPagePO.openPage();
        burger.openBurgMenu();
        burger.checkSert(check);
    }

    @Test
    @Tag("Currency")
    @DisplayName("Меняем валюту")
    void franshizaTabTest() {
        mainPagePO.openPage();
        currency.clickCurrencyButton().selectCurrency();
        currency.checkCurrencyResult("BYN");
    }

    @Test
    @Tag("MapTest")
    @DisplayName("Чекаем маппинг языка")
    void checkingLanguageMappingTest() {
        mainPagePO.openPage();
        address.clickAddressButton();
        address.inputAddress("Jhlsyrf");
        address.checkListOfAddress("улица Большая Ордынка");
    }
    @Test
    @Tag("AviaTest")
    @DisplayName("Переключение на страницу авиа")
    void aviaTest() {
        mainPagePO.openPage();
        Aviasw.openAviaPage();
        Aviasw.result("Популярные направления");

    }
        @Test
        @Tag("AviaTest")
        @DisplayName("Смотрим популярные рейсы")
        void aviaTest2() {
        mainPagePO.openPage();
        Aviasw.openAviaPage();
        popularFlies.ScrollToFlies();
        popularFlies.resultCh();

        }
}

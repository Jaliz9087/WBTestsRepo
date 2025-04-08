package uitests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import pages.*;
import utils.ForFaker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Owner("-whey-")
@Epic("Main Page Tests")
@Tags({@Tag("main"), @Tag("AllTests")})
public class MainPageTests extends TestBase {
    MainPagePO mainPagePO = new MainPagePO();
    ForFaker forFaker = new ForFaker();
    LoginPage loginPage = new LoginPage();
    BurgerPage burger = new BurgerPage();
    CardPage card = new CardPage();
    CurrencyPage currency = new CurrencyPage();
    SearchGoodsPage searchGoods = new SearchGoodsPage();


    @Test
    @DisplayName("Получаем ошибку при вводе невалидного номера")
    @Tag("NegativeTest")
    void failedLoginTest() {
        mainPagePO.openPage();
        mainPagePO.skipBanners();
        loginPage.loginClick();
        loginPage.inputNum(forFaker.UserNumber);
        loginPage.error();
    }

    @Test
    @DisplayName("Ищем iPhone и добавляем в корзину")
    @Tag("SearchNBasket")
    void searchIphoneTest() {
        mainPagePO.openPage();
        mainPagePO.skipBanners();
        searchGoods.setOurGoods("iphone 16");
        searchGoods.resultsCheck("iPhone 16");
        searchGoods.clickGoodsCard("iPhone 16");
        card.dropToBasket().basketClick();

    }

    @ParameterizedTest
    @ValueSource(strings = {"Сертификаты Wildberries"})
    @DisplayName("Смотрим сертификаты")
    @Tag("BurgerTest")
    void checkBrowserPageTest(String check) {
        mainPagePO.openPage();
        mainPagePO.skipBanners();
        burger.openBurgMenu();
        burger.checkSert(check);
    }

    @Test
    @Tag("Currency")
    @DisplayName("Меняем валюту")
    void franshizaTabTest() {
        mainPagePO.openPage();
        mainPagePO.skipBanners();
        currency.clickCurrencyButton().selectCurrency();
        currency.checkCurrencyResult("BYN");
    }
}

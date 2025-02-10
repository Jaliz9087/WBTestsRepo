import io.qameta.allure.Step;
import pages.*;
import utils.ForFaker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    void failedLoginTest() {
        mainPagePO.openPage();
        loginPage.loginClick();
        loginPage.inputNum(forFaker.UserNumber);
        loginPage.Error();
    }

    @Test
    @DisplayName("Search Dolphin n drop to basket =)")
    @Tag("SearchNBasket")
    void searchFlipperTest() {
        mainPagePO.openPage();
        searchGoods.setOurGoods("Flipper Zero");
        searchGoods.resultsCheck("Flipper Zero");
        searchGoods.clickGoodsCard("Flipper Zero");
        card.dropToBasket().basketClick();
        basket.basketResult("Мультитул Flipper Zero");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Сертификаты Wildberries"})
    @DisplayName("Смотрим серты в бургере")
    @Tag("BurgerTest")
    void checkBrowserPageTest(String check) {
        mainPagePO.openPage();
        burger.openBurgMenu();
        burger.checkSert(check);
    }

    @Test
    @Tag("Currency")
    @DisplayName("Switch currency")
    void franshizaTabTest() {
        mainPagePO.openPage();
        currency.clickCurrencyButton().selectCurrency();
        currency.checkCurrencyResult("BYN");
    }

    @Test
    @Tag("MapTest")
    @DisplayName("Чекнем маппинг языка при вводе на латинице")
    void checkingLanguageMappingTest() {
        mainPagePO.openPage();
        address.clickAddressButton();
        address.inputAddress("Jhlsyrf");
        address.checkListOfAddress("улица Большая Ордынка");
    }
}

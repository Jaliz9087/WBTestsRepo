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
        openLoginPage();
        enterInvalidPhoneNumber(forFaker.UserNumber);
        checkErrorMessage();
    }

    @Step("Открываем страницу логина и нажимаем на кнопку входа")
    public void openLoginPage() {
        mainPagePO.openPage();
        loginPage.loginClick();
    }

    @Step("Вводим невалидный номер: {number}")
    public void enterInvalidPhoneNumber(String number) {
        loginPage.inputNum(number);
    }

    @Step("Проверяем появление ошибки")
    public void checkErrorMessage() {
        loginPage.Error();
    }

    @Test
    @DisplayName("Search Dolphin n drop to basket =)")
    @Tag("SearchNBasket")
    void searchFlipperTest() {
        openMainPage();
        searchAndCheckFlipperZero();
        addToBasket();
        checkBasket();
    }

    @Step("Открываем главную страницу")
    public void openMainPage() {
        mainPagePO.openPage();
    }

    @Step("Ищем Flipper Zero и проверяем найденный товар")
    public void searchAndCheckFlipperZero() {
        searchGoods.setOurGoods("Flipper Zero");
        searchGoods.resultsCheck("Flipper Zero");
        searchGoods.clickGoodsCard("Flipper Zero");
    }

    @Step("Добавляем товар в корзину")
    public void addToBasket() {
        card.dropToBasket()
                .basketClick();
    }

    @Step("Проверяем корзину на наличие Flipper Zero")
    public void checkBasket() {
        basket.basketResult("Мультитул Flipper Zero");
    }

    @ValueSource(strings = {"Сертификаты Wildberries"})
    @ParameterizedTest
    @DisplayName("Смотрим серты в бургере")
    @Tag("BurgerTest")
    void checkBrowserPageTest(String check) {
        openBurgerMenu();
        checkCertificatesTab(check);
    }

    @Step("Открываем страницу и бургер-меню")
    public void openBurgerMenu() {
        mainPagePO.openPage();
        burger.openBurgMenu();
    }

    @Step("Проверяем вкладку сертификатов: {check}")
    public void checkCertificatesTab(String check) {
        burger.checkSert(check);
    }

    @Test
    @Tag("Currency")
    @DisplayName("Switch currency")
    void franshizaTabTest() {
        openMainPage();
        selectCurrencyByn();
        checkSelectedCurrency();
    }

    @Step("Кликаем по валюте и выбираем BYN")
    public void selectCurrencyByn() {
        currency.clickCurrencyButton()
                .selectCurrency();
    }

    @Step("Проверяем, что выбрана валюта: BYN")
    public void checkSelectedCurrency() {
        currency.checkCurrencyResult("BYN");
    }

    @Test
    @Tag("MapTest")
    @DisplayName("Чекнем маппинг языка при вводе на латинице")
    void checkingLanguageMappingTest() {
        openPageAndClickAddress();
        enterAddress();
        checkAddressList();
    }

    @Step("Открываем страницу и кликаем по адресам")
    public void openPageAndClickAddress() {
        mainPagePO.openPage();
        address.clickAddressButton();
    }

    @Step("Вводим адрес на латинице")
    public void enterAddress() {
        address.inputAddress("Jhlsyrf");
    }

    @Step("Проверяем лист адресов, должен содержать: улица Большая Ордынка")
    public void checkAddressList() {
        address.checkListOfAddress("улица Большая Ордынка");
    }
}

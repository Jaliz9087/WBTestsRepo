package uitests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AviaSwitchPage;
import pages.ClosePageForAvia;
import pages.MainPagePO;
import pages.PopularFliesPage;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;

@Owner("-whey-")
@Epic("AviaTests")
@Tags({@Tag("avia"), @Tag("AllTests")})
public class AviaTests extends TestBase {
    MainPagePO mainPagePO = new MainPagePO();
    AviaSwitchPage aviaSw = new AviaSwitchPage();
    PopularFliesPage popularFlies = new PopularFliesPage();
    ClosePageForAvia closePage = new ClosePageForAvia();

    @Test
    @Tag("AviaTest")
    @DisplayName("Переключение на страницу авиа")
    void aviaTest() {
        clearBrowserCookies();
        mainPagePO.openPage();
        mainPagePO.skipBanners();
        aviaSw.openAviaPage();
        closePage.closePage();
        aviaSw.checkResult("Билеты");
    }
    @Test
    @Tag("AviaTest")
    @DisplayName("Смотрим популярные рейсы")
    void aviaTest2() {
        mainPagePO.openPageAvia();
        popularFlies.scrollToFlies();
        popularFlies.resultCh();

    }
}

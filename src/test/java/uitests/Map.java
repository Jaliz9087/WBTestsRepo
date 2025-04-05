package uitests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AddressPage;
import pages.MainPagePO;
@Owner("-whey-")
@Epic("Language Mapping Test")
@Tags({@Tag("mapp"), @Tag("AllTests")})
public class Map extends TestBase {
    MainPagePO mainPagePO = new MainPagePO();
    AddressPage address = new AddressPage();

    @Test
    @Tag("MapTest")
    @DisplayName("Чекаем маппинг языка")
    void checkingLanguageMappingTest() {
        mainPagePO.openPage();
        address.clickAddressButton();
        address.inputAddress("Jhlsyrf");
        address.checkListOfAddress("улица Большая Ордынка");
    }
}

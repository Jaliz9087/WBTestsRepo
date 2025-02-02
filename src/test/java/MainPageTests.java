import PO.MainPagePO;


import Utils.ForFaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



public class MainPageTests {
    MainPagePO mainPagePO = new MainPagePO();
    ForFaker forFaker = new ForFaker();

    @Test
    @DisplayName("Получаем ошибку при вводе невалидного номера телефона")
    @Tag("NegativeTest")
    void failedLoginTest(){
        mainPagePO.openPage()
                .loginClick()
                .inputNum(forFaker.UserNumber)
                .Error();
    }
   @Test
   @DisplayName("Search Dolphin n drop to basket =)")
//    @Tag()
    void searchSmth(){
        mainPagePO.openPage()
                .setOurGoods("Flipper Zero")
                .resultsCheck("Flipper Zero")
                 .clickGoodsCard("Atlass")
                .dropToBasket()
                .basketClick()
                .basketResult("Мультитул Flipper Zero");






    }
}

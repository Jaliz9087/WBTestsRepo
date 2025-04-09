package pages;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.util.ArrayList;

public class ClosePageForAvia {
    public ClosePageForAvia closePage() {
        ArrayList<String> windows = new ArrayList<>(getWebDriver().getWindowHandles());

        switchTo().window(windows.get(1));     // Переключаемся на второе
        switchTo().window(windows.get(0)).close(); // Закрываем первое

        // Обновляем список окон
        ArrayList<String> updatedWindows = new ArrayList<>(getWebDriver().getWindowHandles());
        switchTo().window(updatedWindows.get(0)); // Переключаемся на оставшееся окно

        return this;
    }
}

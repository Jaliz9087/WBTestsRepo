# Проект автоматизации тестирования для [**Wildberries**](https://www.wildberries.ru/)

**Wildberries** — международный онлайн-маркетплейс с огромным ассортиментом товаров: от одежды, обуви, детских товаров до электроники и аксессуаров для дома.

---
## *Содержание*:

- [Технологии и инструменты](#tools)
- [Примеры автоматизированных тест-кейсов](#cases)
- [Сборка в Jenkins](#jenkins)
- [Запуск из терминала](#console)
- [Allure отчет](#allure)
- [Уведомление в Telegram](#telegram)
- [Примеры видео выполнения тестов на Selenoid](#video)

---
<a id="tools"></a>
## **🛠️ Технологии и инструменты**

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="icons/idea.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="icons/java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="icons/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="icons/junit.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="icons/gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="icons/selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="icons/selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="icons/allure.svg" width="50" height="50"  alt="Allure"/></a>  
<a href="https://www.jenkins.io/"><img src="icons/jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
</p>

---
<a id="cases"></a>
## **✅ Примеры автоматизированных тест-кейсов**

- ✓ *Проверка ошибки при вводе невалидного номера телефона*
- ✓ *Проверка поиска товара и добавления в корзину*
- ✓ *Проверка работы бургер-меню*
- ✓ *Проверка изменения валюты*
- ✓ *Проверка маппинга латиницы при поиске улицы на карте*

---
<a id="jenkins"></a>
## **🚀 Сборка в Jenkins**

### [Jenkins-сборка](https://jenkins.autotests.cloud/job/whey-WBTest-QG14/)

<p align="center">  
<a href="https://jenkins.autotests.cloud/job/whey-WBTest-QG14/"><img src="screens/JenkinsJob.png" alt="Jenkins" width="950"/></a>  
</p>

### **Параметры сборки в Jenkins:**

- `browser` (браузер, по умолчанию Chrome)
- `browserVersion` (версия браузера, по умолчанию 126)
- `browserSize` (размер окна браузера, по умолчанию 1920x1080)
- `remoteUrl` (логин, пароль и адрес удаленного сервера Selenoid)

---
<a id="console"></a>
## **🖥️ Команды для запуска из терминала**

### **Локальный запуск:**
```bash  
gradle clean AllTests
```

### **Удалённый запуск через Jenkins:**
```bash  
gradle clean AllTests \
  -Dbrowser=${BROWSER} \
  -DbrowserSize=${BROWSER_SIZE} \
  -DbrowserVersion=${BROWSER_VERSION} \
  -DremoteHost=${WDHOST}
```

---
<a id="allure"></a>
## **📊 Allure отчет**

### [Allure отчет](link)

<p align="center">  
<a href="link"><img src="screens/AllureReport.png" alt="Allure" width="950"/></a>  
</p>

---
<a id="telegram"></a>
## **📩 Уведомление в Telegram при помощи бота**

Автоматическое уведомление о результатах тестов отправляется в Telegram через бота.

---
<a id="video"></a>
## **🎥 Примеры видео выполнения тестов на Selenoid**

Видео-записи выполнения тестов доступны в Selenoid. Они помогают анализировать тестовые сценарии и находить потенциальные ошибки.

---

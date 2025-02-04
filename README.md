# Проект автоматизации тестирования для [**Wildberries**](https://www.wildberries.ru/)
---
>**Wildberries**-еждународный онлайн-маркетплейс с огромным ассортиментом: от одежды, обуви, детских товаров до электроники и аксессуаров для дома.
---
## *Содержание*:
---
* <a href="#tools">Технологии и инструменты</a> 
* <a href="#cases">Примеры автоматизированных тест-кейсов</a>  
* <a href="#jenkins">Сборка в Jenkins</a>  
* <a href="#console">Запуск из терминала</a>  
* <a href="#allure">Allure отчет</a>
* <a href="#telegram">Уведомление в Telegram при помощи бота</a>  
* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
---
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="icons/idea.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="icons/java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="icons/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="icons/junit.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="icons/gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="icons/selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="icons/selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="icons/allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="icons/jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  

</p>
---
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
---
- ✓ *Проверка ошибки при вводе невалидного номера телефона*
- ✓ *Проверка поиска товара и дропа его в корзину*
- ✓ *Проверка работы бургера*
- ✓ *Проверка изменения валюты*
- ✓ *Проверка маппинга латиницы при поиске улицы на карте*

---
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="icons/jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/whey-WBTest-QG14/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/whey-WBTest-QG14/"><img src="screens/JenkinsJob.png" alt="Jenkins" width="950"/></a>  
</p>
---
# **Параметры сборки в Jenkins:**

- *browser (браузер, по умолчанию chrome)*
- *browserVersion (версия браузера, по умолчанию 126)*
- *browserSize (размер окна браузера, по умолчанию 1920x1080)*
- *remoteUrl (логин, пароль и адрес удаленного сервера Selenoid)*

---
<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean AllTests
```

***Удалённый запуск через Jenkins:***
```bash  
clean X5Group_test
"-Dbrowser=${BROWSER}"
"-DbrowserSize=${BROWSER_SIZE}"
"-DbrowserVersion=${BROWSER_VERSION}"
"-DremoteHost=${WDHOST}"
```
---
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/Kod3ik_qa_guru_x5/allure/)</a>
___
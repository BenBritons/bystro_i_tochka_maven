# Быстро и точка
## 1. Описание
Сайт доставки еды. С несколькими типами еды, корзиной, возможностью выкладывания объявлений с помощью сайта, возможностью заказа доставки, учетные записи клиента, доставщика, продавца еды, админ-редактор. Пользователи могут рассматривать объявления о продаже еды, заказывать блюдо на конкретный адрес, регистрироваться, оставлять отзывы о еде и продавце. Клиент заказывает еду, оставляет отзывы. Доставщик может брать заказ, просматривать информацию о заказе. Продавец еды может размещать заказы. Администратор-редактор может банить пользователей, продавцов, заказчиков, удалять\размещать объявления, комментарии.
Цели проекта:  
Наш проект не преследует какие-либо бизнес-цели, его разработка целенаправлена на получение опыта в разработке аналогичных проектов.

## 2. Используемые технологии
Для разработки данного проекта мы использовали технологии, указанные в следующем списке:
-  Java 19
-  Apache Tomcat - контейнер сервлетов Java для развертывания веб-приложений
-  Maven - инструмент для управления зависимостями, сборки проекта и управления жизненным циклом проекта
-  MySQL - СУБД проекта
-  Apache Logging Log4j2 - библиотека для логирования
-  JSTL - библиотека тегов для разработки веб-приложений с использованием технологии JSP
-  io.swagger - набор инструментов и библиотек, предназначенных для работы со Swagger
-  Connection Pool для управления подключениями к базе данных.
-  JUnit - фреймворк для модульного тестирования
-  Bootstrap v5.0.0
-  HTML
-  CSS
-  JavaScript

## 3. Use case diagram
![Use case diagram](src/main/webapp/images/usecasediagram.jpg)

## 4. ER-модель базы данных
![ER Model](src/main/webapp/images/ermodel.jpg)

## 5. Диаграммы классов
#Entity
![Entity](src/main/webapp/images/entity.jpg)
#Dao
![Dao](src/main/webapp/images/dao.jpg)
#Service
![Service](src/main/webapp/images/service.jpg)
#Servlet
![Servlet](src/main/webapp/images/servlet.jpg)

## Диаграмма компонентов и диаграмма развертывания
![Diagram](src/main/webapp/images/diagram.jpg)

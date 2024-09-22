# Neoflex_test task 
## Требования для выполнения
 Приложение "Калькулятор отпускных"

Микросервис на SpringBoot + Java 11 c одним API:
GET "/calculacte"
Минимальные требования: Приложение принимает твою среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.
Доп. задание: При запросе также можно указать точные дни ухода в отпуск, тогда должен проводиться рассчет отпускных с учётом праздников и выходных.

Проверяться будет чистота кода, структура проекта, название полей\классов, правильность использования паттернов. Желательно написание юнит-тестов, проверяющих расчет.

# Cтек проекта
- Spring Boot
- Java 11
- JUnit
- Mockito
- Swagger
- Docker
- MockMvc


## API requests
Простой запрос: 
``` http://localhost:8080/calculate?averageSalary=30500.00&vacationDays=30 ```

Запрос с указанием точного дня ухода в отпуск: ``` http://localhost:8080/calculate?averageSalary=30500&vacationDays=30&dateOfDeparture=2022-02-25 ```
## Postman
![Photo](https://github.com/nekruz03/Neoflex-Test-Task/blob/main/docs/images/img.png)

---
![Photo](https://github.com/nekruz03/Neoflex-Test-Task/blob/main/docs/images/img_1.png)
## Docker
- Сборка Docker-образа

Для начала, убедитесь, что у вас установлен Docker. Если Docker не установлен, можно скачать и установить его [по этой ссылке](https://www.docker.com/get-started).

```bash
docker build -t vacation-pay-calculator . 
```
- Запуск контейнера
```bash
docker run -p 8080:8080 vacation-pay-calculator 
```




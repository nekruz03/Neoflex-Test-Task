# Используем базовый образ с JDK 17
FROM openjdk:17-jdk-slim

# Указываем рабочую директорию
WORKDIR /app

# Копируем файл сборки приложения (например, JAR-файл) в контейнер
COPY target/Neo_study-0.0.1-SNAPSHOT.jar app.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]

# Определяем порт, который будет открыт
EXPOSE 8080

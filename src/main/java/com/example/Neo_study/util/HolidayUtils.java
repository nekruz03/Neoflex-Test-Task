package com.example.Neo_study.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

public class HolidayUtils {

    // Получение списка праздников для конкретного года
    public static Set<LocalDate> getHolidays(int year) {
        return Set.of(
                LocalDate.of(year, 1, 1),
                LocalDate.of(year, 1, 2),
                LocalDate.of(year, 1, 3),
                LocalDate.of(year, 1, 4),
                LocalDate.of(year, 1, 5),
                LocalDate.of(year, 1, 6),
                LocalDate.of(year, 1, 7),
                LocalDate.of(year, 1, 8),
                LocalDate.of(year, 2, 23),
                LocalDate.of(year, 3, 8),
                LocalDate.of(year, 5, 1),
                LocalDate.of(year, 5, 9),
                LocalDate.of(year, 6, 12),
                LocalDate.of(year, 11, 4)
        );
    }

    // Проверка, является ли день рабочим
    public static boolean isWorkingDay(LocalDate date, Set<LocalDate> holidays) {
        return date.getDayOfWeek() != DayOfWeek.SATURDAY &&
                date.getDayOfWeek() != DayOfWeek.SUNDAY &&
                !holidays.contains(date);
    }
}

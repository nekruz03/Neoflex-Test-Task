package com.example.Neo_study.HolidayUtilsTest;

import com.example.Neo_study.util.HolidayUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HolidayUtilsTest {

    @Test
    void testIsHoliday() {
        Set<LocalDate> holidays = HolidayUtils.getHolidays(2024);
        LocalDate holiday = LocalDate.of(2024, 1, 1);
        assertTrue(holidays.contains(holiday));
    }

    // Тест проверки, что день не является рабочим (выходной)
    @Test
    void testIsWorkingDay() {
        Set<LocalDate> holidays = HolidayUtils.getHolidays(2024);

        // Проверим рабочий день
        LocalDate workingDay = LocalDate.of(2024, 2, 20);
        assertTrue(HolidayUtils.isWorkingDay(workingDay, holidays));

        // Проверим выходной день (например, воскресенье)
        LocalDate weekend = LocalDate.of(2024, 2, 25);
        assertFalse(HolidayUtils.isWorkingDay(weekend, holidays));
    }
}

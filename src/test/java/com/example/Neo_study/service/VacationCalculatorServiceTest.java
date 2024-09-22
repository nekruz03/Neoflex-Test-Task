package com.example.Neo_study.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationCalculatorServiceTest {

    private final VacationCalculatorService vacationCalculatorService = new VacationCalculatorService();

    // Тест для обычного расчета без учета праздников
    @Test
    void testCalculate() {
        // Проверка правильного расчета без учета праздников
        double result = vacationCalculatorService.calculate(30000, 10);
        assertEquals(10238.91, result, 0.01); // Ожидаемое значение после округления
    }

    // Тест для расчета с учетом праздников
    @Test
    void testCalculateWithHolidays() {
        // Указываем дату отпуска
        LocalDate startDate = LocalDate.of(2024, 2, 20);
        double result = vacationCalculatorService.calculateWithHolidays(30000, 10, startDate);
        assertEquals(7167.24, result, 0.01); // Ожидаемое значение после округления
    }
}

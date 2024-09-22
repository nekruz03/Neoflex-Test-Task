package com.example.Neo_study.service;

import com.example.Neo_study.util.HolidayUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Set;

@Service
public class VacationCalculatorService {

    private static final double DAYS_IN_MONTH = 29.3;

    public double calculate(double averageSalary, int vacationDays) {
        double result = (averageSalary / DAYS_IN_MONTH) * vacationDays;
        return roundToTwoDecimalPlaces(result); // Округление результата
    }

    public double calculateWithHolidays(double averageSalary, int vacationDays, LocalDate dateOfDeparture) {
        int numberOfVacationDays = 0;
        Set<LocalDate> holidays = HolidayUtils.getHolidays(dateOfDeparture.getYear());

        for (int i = 0; i < vacationDays; i++) {
            if (HolidayUtils.isWorkingDay(dateOfDeparture, holidays)) {
                numberOfVacationDays++; // Считаем только рабочие дни
            }
            dateOfDeparture = dateOfDeparture.plusDays(1);
        }

        double result = (averageSalary / DAYS_IN_MONTH) * numberOfVacationDays;
        return roundToTwoDecimalPlaces(result); // Округляем результат
    }

    // Метод для округления до двух знаков после запятой
    private double roundToTwoDecimalPlaces(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

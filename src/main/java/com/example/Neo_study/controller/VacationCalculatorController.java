package com.example.Neo_study.controller;

import com.example.Neo_study.service.VacationCalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@Tag(name = "Vacation Pay Calculator", description = "API для расчета отпускных выплат")
public class VacationCalculatorController {

    private final VacationCalculatorService vacationCalculatorService;

    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @GetMapping("/calculate")
    @Operation(summary = "Расчет отпускных", description = "Метод рассчитывает отпускные выплаты на основе средней зарплаты и количества дней отпуска.")
    public double calculateVacationPay(
            @Parameter(description = "Средняя зарплата за последние 12 месяцев") @RequestParam("averageSalary") double averageSalary,
            @Parameter(description = "Количество дней отпуска") @RequestParam("vacationDays") int vacationDays,
            @Parameter(description = "Дата  начала отпуска в формате 'yyyy-mm-dd'. Если не указана, расчет без учета праздничных дней")
            @RequestParam(required = false) LocalDate dateOfDeparture) {

        double result;

        if (dateOfDeparture == null) {
            result = vacationCalculatorService.calculate(averageSalary, vacationDays);
        } else {
            result = vacationCalculatorService.calculateWithHolidays(averageSalary, vacationDays, dateOfDeparture);
        }

        return Math.round(result * 100.0) / 100.0;
    }
}

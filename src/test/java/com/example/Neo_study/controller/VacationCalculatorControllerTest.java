package com.example.Neo_study.controller;

import com.example.Neo_study.service.VacationCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

@WebMvcTest(VacationCalculatorController.class)
public class VacationCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VacationCalculatorService vacationCalculatorService;

    @BeforeEach
    void setUp() {
        // Мокаем поведение сервиса
        given(vacationCalculatorService.calculate(anyDouble(), anyInt()))
                .willReturn(10000.00);

        given(vacationCalculatorService.calculateWithHolidays(anyDouble(), anyInt(), any(LocalDate.class)))
                .willReturn(8000.00);
    }

    @Test
    void testCalculateVacationPayWithoutHolidays() throws Exception {
        mockMvc.perform(get("/calculate")
                        .param("averageSalary", "30000")
                        .param("vacationDays", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("10000.0"));
    }

    @Test
    void testCalculateVacationPayWithHolidays() throws Exception {
        mockMvc.perform(get("/calculate")
                        .param("averageSalary", "30000")
                        .param("vacationDays", "10")
                        .param("dateOfDeparture", "2024-02-20"))
                .andExpect(status().isOk())
                .andExpect(content().string("8000.0"));
    }
}

package ru.neoflex.vacationcalc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.vacationcalc.service.VacationService;

@RestController
@RequiredArgsConstructor
public class VacationController {
    private final VacationService vacationService;
    @GetMapping(value = "/calculate")
    public ResponseEntity<String> getVacationPayment(@RequestParam(value = "days") Integer days, @RequestParam(value = "paymentAvg") String paymentAvg) {
        return ResponseEntity.ok(vacationService.calculateVacationPayment(days, paymentAvg));
    }

}

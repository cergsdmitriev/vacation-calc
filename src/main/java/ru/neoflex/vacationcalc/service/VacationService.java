package ru.neoflex.vacationcalc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
@RequiredArgsConstructor
public class VacationService {

    private static final String AVG_DAYS_IN_MONTH = "29.3";
    public String calculateVacationPayment(Integer days, String paymentAvg) {

        // при промежуточных вычислениях используем копейки, в конечном результате округляем до рублей при наличии копеек
        return new BigDecimal(paymentAvg).divide(new BigDecimal(AVG_DAYS_IN_MONTH),2, RoundingMode.UP)
                                         .multiply(BigDecimal.valueOf(days)).setScale(0, RoundingMode.UP).toString();
    }
}

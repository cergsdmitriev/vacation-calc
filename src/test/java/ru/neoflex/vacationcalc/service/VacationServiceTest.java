package ru.neoflex.vacationcalc.service;


import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.neoflex.vacationcalc.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class VacationServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    @DisplayName("Корректные данные. Успех")
    public void calculateVacationPayment_correctData_success() {

        MvcResult result = mockMvc.perform(get("/calculate")
                        .param("days", "14")
                        .param("paymentAvg", "50000"))
                .andReturn();
        Assertions.assertEquals(result.getResponse().getContentAsString(), "23891");
    }

}

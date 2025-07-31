package com.maia.vinicius.desafiobackenditau.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveRetornar200QuandoPayloadForValido() throws Exception {
        String json = """
            {
                "value": 100.00,
                "dateTime": "2025-07-31T18:55:43+01:00"
            }
        """;

        mockMvc.perform(post("/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

//    @Test
//    public void deveRetornar400QuandoPayloadForInvalido() throws Exception {
//        String json = """
//            {
//                "valuee": null,
//                "dat3eTime": null
//            }
//        """;
//
//        mockMvc.perform(post("/transaction")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isBadRequest());
//    }

    @Test
    public void deveRetornar422QuandoPayloadTiverValoresInvalidos() throws Exception {
        String json = """
            {
                "value": -125,
                "dateTime": "2025-07-31T18:55:43+01:00"
            }
        """;

        mockMvc.perform(post("/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isUnprocessableEntity());
    }
}


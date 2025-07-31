//package com.maia.vinicius.desafiobackenditau.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.hamcrest.Matchers.containsString;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TransactionControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void deveRetornar200QuandoPayloadForValido() throws Exception {
//        String json = """
//            {
//                "value": 100.00,
//                "dateTime": "2025-07-30T15:30:00"
//            }
//        """;
//
//        mockMvc.perform(post("/transaction")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Transação recebida")));
//    }
//
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
//
//    @Test
//    public void deveRetornar422QuandoPayloadTiverValoresInvalidos() throws Exception {
//        String json = """
//            {
//                "value": -125,
//                "dateTime": "2020-08-07T12:34:56.789-03:00"
//            }
//        """;
//
//        mockMvc.perform(post("/transaction")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isUnprocessableEntity());
//    }
//}
//

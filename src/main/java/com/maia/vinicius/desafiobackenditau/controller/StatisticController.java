package com.maia.vinicius.desafiobackenditau.controller;

import com.maia.vinicius.desafiobackenditau.dto.StatisticResponse;
import com.maia.vinicius.desafiobackenditau.service.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/statistics")
    public ResponseEntity<StatisticResponse> getStatistics(){
        DoubleSummaryStatistics stats = statisticService.getLastStatistics();
        StatisticResponse statisticResponse = new StatisticResponse(stats);
        return ResponseEntity.ok().body(statisticResponse);
    }
}

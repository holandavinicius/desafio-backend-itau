package com.maia.vinicius.desafiobackenditau.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticResponse {

    private Double sum;
    private Long count;
    private Double avg;
    private Double max;
    private Double min;

    public Double getSum() {
        return sum;
    }

    public Long getCount() {
        return count;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
    }

    public StatisticResponse(DoubleSummaryStatistics stats) {
        this.sum = stats.getSum();
        this.count = stats.getCount();
        this.avg = stats.getAverage();
        this.min = count > 0 ? stats.getMin() : 0.0;
        this.max = count > 0 ? stats.getMax() : 0.0;
    }
}

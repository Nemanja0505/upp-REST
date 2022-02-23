package com.damy.data;

import lombok.Data;

@Data
public class CityStatistic {

    private String name;
    private Double percentage;

    public CityStatistic(String name, Double percentage) {
        this.name = name;
        this.percentage = percentage;
    }
}

package com.damy.data;

import lombok.Data;

@Data
public class TimeStatistic {

    private String time;
    private Double numberOfApplications;

    public TimeStatistic(String time, Double numberOfApplications) {
        this.time = time;
        this.numberOfApplications = numberOfApplications;
    }
}

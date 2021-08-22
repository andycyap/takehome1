package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class DailyBalances implements Result {
    private Map<String, Double> dailyBalances = new HashMap<>();

    public Map<String, Double> getDailyBalances() {
        return dailyBalances;
    }
}

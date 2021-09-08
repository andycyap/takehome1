package com.example.demo.model;

import java.util.Map;
import java.util.TreeMap;

public class DailyBalance<DateKey, AmountValue> implements Result {
    private Map<DateKey, AmountValue> dailyBalances = new TreeMap<>();

    public Map<DateKey, AmountValue> getDailyBalances() {
        return dailyBalances;
    }
}

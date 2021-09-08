package com.example.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FormattedDailyBalance implements Result {
    private List<Map.Entry<String, BigDecimal>> formattedDailyBalance = new ArrayList<>();

    public List<Map.Entry<String, BigDecimal>> getFormattedDailyBalances() {
        return formattedDailyBalance;
    }
}

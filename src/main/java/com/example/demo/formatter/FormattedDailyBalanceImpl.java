package com.example.demo.formatter;

import com.example.demo.model.DailyBalance;
import com.example.demo.model.FormattedDailyBalance;
import com.example.demo.model.Result;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FormattedDailyBalanceImpl implements Format {

    @Override
    public Result format(Result input) {
        if(input instanceof DailyBalance) {
            DailyBalance<String, BigDecimal> dailyBalance = (DailyBalance) input;
            FormattedDailyBalance formattedDailyBalance = new FormattedDailyBalance();
            formattedDailyBalance.getFormattedDailyBalances().addAll(dailyBalance.getDailyBalances().entrySet()
                    .stream().collect(Collectors.toList()));
            return formattedDailyBalance;
        }
        return input;
    }
}

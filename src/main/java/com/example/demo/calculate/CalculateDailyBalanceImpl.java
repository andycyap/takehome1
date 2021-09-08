package com.example.demo.calculate;

import com.example.demo.model.DailyBalance;
import com.example.demo.model.Result;
import com.example.demo.model.Transaction;
import com.example.demo.service.BenchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class CalculateDailyBalanceImpl implements Calculate {

    @Autowired
    BenchService benchService;


    @Override
    public Result calculate() throws Exception {
        DailyBalance<String, BigDecimal> dailyBalance = new DailyBalance();

        List<Transaction> transactions = benchService.getAllTransactions();
        for(Transaction transaction : transactions) {
            if(dailyBalance.getDailyBalances().containsKey(transaction.getDate())) {
                BigDecimal currentBalance = dailyBalance.getDailyBalances().get(transaction.getDate());
                dailyBalance.getDailyBalances().put(transaction.getDate(), transaction.getAmount().add(currentBalance));
            } else {
                dailyBalance.getDailyBalances().put(transaction.getDate(), transaction.getAmount());
            }
        }
        return dailyBalance;
    }
}

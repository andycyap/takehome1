package com.example.demo.service;

import com.example.demo.model.DailyBalances;
import com.example.demo.model.Result;
import com.example.demo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateDailyBalanceImpl implements Calculate {

    @Autowired
    BenchService benchService;

    DailyBalances dailyBalances = new DailyBalances();

    @Override
    public Result calculate() throws Exception {
        List<Transaction> transactions = benchService.getAllTransactions();
        for(Transaction transaction : transactions) {
            if(dailyBalances.getDailyBalances().containsKey(transaction.getDate())) {
                Double currentBalance = dailyBalances.getDailyBalances().get(transaction.getDate());
                dailyBalances.getDailyBalances().put(transaction.getDate(), transaction.getAmount() + currentBalance);
            } else {
                dailyBalances.getDailyBalances().put(transaction.getDate(), transaction.getAmount());
            }
        }
        return dailyBalances;
    }
}

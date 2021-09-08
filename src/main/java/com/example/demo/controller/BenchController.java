package com.example.demo.controller;

import com.example.demo.formatter.Format;
import com.example.demo.model.Result;
import com.example.demo.calculate.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bench")
public class BenchController {

    @Autowired
    Calculate dailyBalance;

    @Autowired
    Format formattedDailyBalance;

    @GetMapping("/dailyBalance")
    public Result getDailyBalance() throws Exception {
        return formattedDailyBalance.format(dailyBalance.calculate());
    }
}

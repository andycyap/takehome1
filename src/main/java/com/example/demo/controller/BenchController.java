package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.service.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bench")
public class BenchController {

    @Autowired
    Calculate dailyBalance;

    @GetMapping("/dailyBalance")
    public Result getDailyBalance() throws Exception {
        // TODO: Controller can sort the results in chronological order
        return dailyBalance.calculate();
    }
}

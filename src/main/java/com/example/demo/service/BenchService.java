package com.example.demo.service;

import com.example.demo.model.Transaction;

import java.util.List;

public interface BenchService {
    List<Transaction> getAllTransactions() throws Exception;
}

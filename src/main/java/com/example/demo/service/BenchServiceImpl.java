package com.example.demo.service;

import com.example.demo.model.BenchPage;
import com.example.demo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BenchServiceImpl implements BenchService {

    private static final String BENCH_PAGE = "https://resttest.bench.co/transactions/";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Transaction> getAllTransactions() throws Exception {
        List<Transaction> transactions = new ArrayList<>();
        BenchPage benchPage = null;
        int totalCount = -1;
        int pageNumber = 1;

        while ((benchPage = getBenchPage(pageNumber++)) != null) {
            transactions.addAll(benchPage.getTransactions());
            totalCount = benchPage.getTotalCount();
        }

        System.out.println("size[" + transactions.size() + "]");

        if (transactions.size() != totalCount) {
            throw new Exception("Totals are incorrect");
        }

        return transactions;
    }

    private BenchPage getBenchPage(int pageNumber) {
        try {
            ResponseEntity<BenchPage> response = restTemplate.exchange(BENCH_PAGE + Integer.valueOf(pageNumber) +
                    ".json", HttpMethod.GET, null, new ParameterizedTypeReference<BenchPage>() {

            });
            if (response != null && response.hasBody()) {
                return response.getBody();
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}

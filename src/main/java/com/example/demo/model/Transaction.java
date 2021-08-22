package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Transaction {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("Ledger")
    private String ledger;
    @JsonProperty("Amount")
    private double amount;
    @JsonProperty("Company")
    private String company;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLedger() {
        return ledger;
    }

    public void setLedger(String ledger) {
        this.ledger = ledger;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

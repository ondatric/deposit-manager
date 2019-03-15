package com.ondatra.deposit.model;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class Customer {

    private String name;
    private List<Deposit> deposits;

    public Customer(String name, List<Deposit> deposits) {
        this.name = name;
        this.deposits = deposits;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public BigDecimal getTotalBalanceInDollars() {
        return deposits.stream()
                .map(Deposit::getBalanceInDollars)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    Deposit getBiggestDeposit() {
        return deposits.stream()
                .max(Comparator.comparing(Deposit::getBalanceInDollars))
                .orElse(null);
    }

    public String getName() {
        return name;
    }
}

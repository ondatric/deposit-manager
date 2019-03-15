package com.ondatra.deposit.model;

import com.ondatra.deposit.model.enums.Currency;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerWithLowestSummaryBalance() {
        return customers.stream()
                .min(Comparator.comparing(Customer::getTotalBalanceInDollars))
                .orElse(null);
    }

    public Customer getCustomerWithBiggestDeposit() {
        return customers.stream()
                .max(Comparator.comparing(customer -> customer.getBiggestDeposit().getBalanceInDollars()))
                .orElse(null);
    }

    public BigDecimal getSummaryBalanceOfDepositsByCurrency(Currency currency) {
        return customers.stream()
                .map(Customer::getDeposits)
                .flatMap(Collection::stream)
                .filter(deposit -> deposit.getCurrency().equals(currency))
                .map(Deposit::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

package com.ondatra.deposit.model;

import com.ondatra.deposit.model.enums.Currency;

import java.math.BigDecimal;

public class Deposit {

    private final Currency currency;
    private BigDecimal balance;

    public Deposit(Currency currency, BigDecimal balance) {
        this.currency = currency;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    BigDecimal getBalanceInDollars() {
        return balance.multiply(currency.getToDollarExchangeRate());
    }
}

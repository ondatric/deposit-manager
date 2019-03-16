package com.ondatra.deposit.model;

import com.ondatra.deposit.model.enums.Currency;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BankTest {
    private final Bank bank = new Bank(new ArrayList<Customer>() {{
        add(new Customer("CustomerName1", new ArrayList<Deposit>() {{
            add(new Deposit(Currency.USD, BigDecimal.valueOf(999)));
            add(new Deposit(Currency.BYN, BigDecimal.valueOf(1000)));
            add(new Deposit(Currency.EUR, BigDecimal.valueOf(500)));
        }}));
        add(new Customer("CustomerName2", new ArrayList<Deposit>() {{
            add(new Deposit(Currency.USD, BigDecimal.valueOf(1000)));
        }}));
        add(new Customer("CustomerName3", new ArrayList<Deposit>() {{
            add(new Deposit(Currency.USD, BigDecimal.valueOf(123)));
            add(new Deposit(Currency.EUR, BigDecimal.valueOf(654)));
        }}));
    }});

    @Test
    public void shouldReturnCustomerWithLowestSummaryBalance() {
        Assert.assertEquals(
                "CustomerName3",
                bank.getCustomerWithLowestSummaryBalance().getName());
    }

    @Test
    public void shouldReturnCustomerWithBiggestDeposit() {
        Assert.assertEquals(
                "CustomerName2",
                bank.getCustomerWithBiggestDeposit().getName());
    }

    @Test
    public void shouldReturnSummaryBalanceOfBankDepositsByCurrency() {
        Assert.assertEquals(
                BigDecimal.valueOf(2122),
                bank.getSummaryBalanceOfDepositsByCurrency(Currency.USD)
        );
        Assert.assertEquals(
                BigDecimal.valueOf(1154),
                bank.getSummaryBalanceOfDepositsByCurrency(Currency.EUR)
        );
        Assert.assertEquals(
                BigDecimal.valueOf(1000),
                bank.getSummaryBalanceOfDepositsByCurrency(Currency.BYN)
        );
    }
}

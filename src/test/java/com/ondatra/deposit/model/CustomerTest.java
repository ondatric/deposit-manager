package com.ondatra.deposit.model;

import com.ondatra.deposit.model.enums.Currency;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CustomerTest {
    private final Customer customer = new Customer("Customer", new ArrayList<Deposit>() {{
        add(new Deposit(Currency.USD, BigDecimal.valueOf(999)));
        add(new Deposit(Currency.BYN, BigDecimal.valueOf(1000)));
        add(new Deposit(Currency.EUR, BigDecimal.valueOf(500)));
    }});

    @Test
    public void shouldReturnBiggestDepositOfCustomer() {
        Deposit deposit = customer.getBiggestDeposit();
        Assert.assertEquals(BigDecimal.valueOf(999), deposit.getBalance());
        Assert.assertEquals(Currency.USD, deposit.getCurrency());
    }
}

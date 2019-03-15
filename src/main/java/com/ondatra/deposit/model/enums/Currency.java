package com.ondatra.deposit.model.enums;

import java.math.BigDecimal;

public enum Currency {

    USD(BigDecimal.ONE),
    EUR(BigDecimal.valueOf(1.13)),
    BYN(BigDecimal.valueOf(0.47));

    private final BigDecimal toDollarExchangeRate;

    Currency(BigDecimal rate) {
        toDollarExchangeRate = rate;
    }

    public BigDecimal getToDollarExchangeRate() {
        return toDollarExchangeRate;
    }
}

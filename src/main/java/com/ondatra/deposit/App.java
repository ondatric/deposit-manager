package com.ondatra.deposit;

import com.ondatra.deposit.model.Bank;
import com.ondatra.deposit.model.Customer;
import com.ondatra.deposit.model.Deposit;
import com.ondatra.deposit.model.enums.Currency;

import java.math.BigDecimal;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank(new ArrayList<Customer>() {{
            add(new Customer("ondatra", new ArrayList<Deposit>() {{
                add(new Deposit(Currency.USD, BigDecimal.valueOf(999)));
                add(new Deposit(Currency.BYN, BigDecimal.valueOf(1000)));
                add(new Deposit(Currency.EUR, BigDecimal.valueOf(500)));
            }}));
            add(new Customer("ondatric", new ArrayList<Deposit>() {{
                add(new Deposit(Currency.USD, BigDecimal.valueOf(1000)));
            }}));
            add(new Customer("ondatraz", new ArrayList<Deposit>() {{
                add(new Deposit(Currency.USD, BigDecimal.valueOf(123)));
                add(new Deposit(Currency.EUR, BigDecimal.valueOf(654)));
            }}));

        }});
        System.out.print("Customers:\n");
        bank.getCustomers().forEach(customer -> {
            System.out.printf("\tName: %s,\n\tBalance: \n", customer.getName());
            customer.getDeposits().forEach(deposit -> System.out.printf("\t\t%s: %s\n", deposit.getCurrency().toString(), deposit.getBalance()));
            System.out.printf("\tTotal Balance in USD: %s\n\n", customer.getTotalBalanceInDollars());
        });
        System.out.printf("Total currency count (USD/EUR/BYN): %s/%s/%s\n",
                bank.getSummaryBalanceOfDepositsByCurrency(Currency.USD),
                bank.getSummaryBalanceOfDepositsByCurrency(Currency.EUR),
                bank.getSummaryBalanceOfDepositsByCurrency(Currency.BYN));
        System.out.printf("Customer with biggest deposit: %s\n", bank.getCustomerWithBiggestDeposit().getName());
        System.out.printf("Customer with lowest summary balance: %s\n", bank.getCustomerWithLowestSummaryBalance().getName());
    }
}

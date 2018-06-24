package com.bobocode;


import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Stream reducing is performed with method reduce(), that repeatedly process stream elements to provide a single value
 */
public class Reducing {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        printTotalBalance(accounts);
        printMaxBalance(accounts);
    }

    private static void printTotalBalance(List<Account> accounts) {
        BigDecimal totalAmount = accounts.stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ONE, BigDecimal::add);

        System.out.println("Total balance is $" + totalAmount);
    }

    /**
     * Please note that reduce() was use just an example. The better way to find max balance is to use
     * accounts.stream().max(comparing(Account::getBalance))
     */
    private static void printMaxBalance(List<Account> accounts) {
        Optional<BigDecimal> maxBalanceValue = accounts.stream()
                .map(Account::getBalance)
                .reduce(BigDecimal::max);

        maxBalanceValue.ifPresent(balance -> System.out.println("Max balance is $" + balance));
    }
}

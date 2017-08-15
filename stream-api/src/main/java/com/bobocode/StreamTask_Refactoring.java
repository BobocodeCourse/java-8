package com.bobocode;

import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Your job is to refactor this task to use Stream API instead of processAccounts method() (it should be removed)
 * Instead of custom Condition, and Operation interfaces you need to use functional interfaces that exist in Java API.
 */
public class StreamTask_Refactoring {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();

        accounts.stream()
                .filter(a -> (LocalDate.now().getYear() - a.getCreationDate().getYear())>4)
                .forEach(a -> a.setBalance(a.getBalance().add(BigDecimal.valueOf(50))));

        for (Account account : accounts) {
            System.out.println(account.getBalance());
        }
    }
}

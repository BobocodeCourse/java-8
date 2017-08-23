package com.bobocode;

import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Your job is to refactor this task to use Stream API instead of processAccounts method() (it should be removed)
 * Instead of custom Condition, and Operation interfaces you need to use functional interfaces that exist in Java API.
 */
public class StreamTask_Refactoring {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();
        List<Account> finishAccounts = accounts.stream()
                .filter(a -> Period.between(a.getCreationDate().toLocalDate(), LocalDate.now()).getYears() > 4)
                .peek(a -> a.setBalance((a.getBalance().add(BigDecimal.valueOf(50)))))
                .collect(toList());
    }
}

package com.bobocode;

import com.bobocode.functions.Condition;
import com.bobocode.functions.Operation;
import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Your job is to refactor this task to use Stream API instead of processAccounts method() (it should be removed)
 * Instead of custom Condition, and Operation interfaces you need to use functional interfaces that exist in Java API.
 */
public class StreamTask_Refactoring {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList(10);
        accounts.forEach(System.out::println);
        System.out.println();

        Predicate<Account> predicate = a -> Period.between(a.getCreationDate().toLocalDate(), LocalDate.now()).getYears() > 4;
        Consumer<Account> operation = a -> a.setBalance(a.getBalance().add(BigDecimal.valueOf(50)));

        accounts.stream()
                .filter(predicate)
                .peek(operation)
                .forEach(System.out::println);
    }
}

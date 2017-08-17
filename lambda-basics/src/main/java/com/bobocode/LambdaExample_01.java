package com.bobocode;

import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * Parameterization in old Java version.
 *
 * This is a typical example of Java code before version 8. The first class citizens in Java are objects.
 * Therefore we always pass as methods arguments only primitive values, and objects. In other words, we add methods
 * parameters to make methods more universal. But what if we need to parameterize the behavior? What if we need to
 * perform different operations on account list basing on different conditions? That's called behavior parameterization.
 *
 * Behavior parameterization can be achieved by passing some function as methods parameter, but Java does not allow us
 * to pass functions as method parameters. Does it?
 *
 * Let's try to solve this problem with old Java style. We can not pass a function, but we can create an interface
 * with one method, and then pass its anonymous implementation with required logic. That's much more flexible right?
 *
 * See LambdaExample_02.java
 *
 * */
public class LambdaExample_01 {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();
        giveBonusForLoyalClients(accounts, 4, BigDecimal.valueOf(50));
    }

    private static void giveBonusForLoyalClients(List<Account> accounts, int yearsWithBank, BigDecimal bonus) {
        for (Account account : accounts) {
            // todo: HARD CODED condition should be passed as method argument
            if (Period.between(account.getCreationDate().toLocalDate(), LocalDate.now()).getYears() >= yearsWithBank) {
                // todo: HARD CODED operation should be passed as method argument
                account.setBalance(account.getBalance().add(bonus));
            }
        }
    }
}

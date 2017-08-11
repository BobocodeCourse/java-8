package com.bobocode;

import com.bobocode.functions.Condition;
import com.bobocode.functions.Operation;
import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * Your job is to refactor this task to use Stream API instead of processAccounts method() (it should be removed)
 * Instead of custom created Condition, and Operation interfaces you need to used existing functional interfaces.
 */
public class SreamTask_Refactoring {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();
        processAccounts(accounts,
                a -> Period.between(a.getCreationDate(), LocalDate.now()).getYears() > 4,
                a -> a.setBalance(a.getBalance().add(BigDecimal.valueOf(50))));
    }

    private static void processAccounts(List<Account> accounts, Condition<Account> condition,
                                        Operation<Account> operation) {
        for (Account account : accounts) {
            if (condition.isTrue(account)) {
                operation.apply(account);
            }
        }
    }
}

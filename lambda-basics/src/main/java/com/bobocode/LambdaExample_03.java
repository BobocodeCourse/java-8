package com.bobocode;

import com.bobocode.functions.Condition;
import com.bobocode.functions.Operation;
import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static java.time.Period.between;

/**
 * Behavior parameterization with Lambdas.
 *
 * Lambdas allow you to provide only required specific code, and make code clear. Lambda is an anonymous method, but
 * it is always assigned to some interface. It can be assigned to an interface variable, or passes as method argument.
 * Lambda should be always compatible with its target type, which is specified by some interface. Such interface
 * is called Functional interface, because it represents only one function that is defined by one abstract method.
 *
 * See LambdaExample_04.java for different target typing examples
 *
 */
public class LambdaExample_03 {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();
        processAccounts(accounts,
                a -> Period.between(a.getCreationDate().toLocalDate(), LocalDate.now()).getYears() > 4,
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

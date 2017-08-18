package com.bobocode;

import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;
import java.util.List;
import java.util.Optional;

/**
 * Using Stream API, lambdas, and predefined functional interfaces implement the code according to requirements
 */

public class StreamTask_Reducing {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();
        accounts.forEach(System.out::println);
        System.out.println();

        // 1 - Calculate sum of all account balances using reduce() method that receives two parameters:
        // default value and lambda (DO NOT USE METHOD REFERENCE)
        int resultOfSum = accounts.stream()
                .map(e -> e.getBalance().intValue())
                .reduce(0,(s1, s2) -> s1+s2);
        System.out.println("Result of sum: " + resultOfSum);
        System.out.println();

        // 2 - Compute the amount of all stream elements using reduce methods that receives two parameters
        // default value and lambda (DO NOT USE METHOD REFERENCE)
        int sumReduce = accounts.stream()
                .map(account -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Total amount with reduce method: " + sumReduce);
        System.out.println();

        // 3 - Concatenate all last names into a single string, separated by commas, using reduce() method
        Optional<String> lastFamilies = accounts.stream()
                .map(Account::getLastName)
                .reduce((s1, s2) -> (s1 + "," + s2));
        System.out.println("Last families: " + lastFamilies.orElse("empty list"));
    }
}

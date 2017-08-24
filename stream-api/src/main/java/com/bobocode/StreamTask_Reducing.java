package com.bobocode;


import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Using Stream API, lambdas, and predefined functional interfaces implement the code according to requirements
 */
public class StreamTask_Reducing {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();

        // 1 - Calculate sum of all account balances using reduce() method that receives two parameters:
        // default value and lambda (DO NOT USE METHOD REFERENCE)

        double resultAccountsBalance = accounts.stream()
                .mapToDouble(a -> a.getBalance().doubleValue())
                .reduce(0, (a, b) -> a + b);

        System.out.println(resultAccountsBalance);

        System.out.println("--------------------------------");

        // 2 - Compute the amount of all stream elements using reduce methods that receives two parameters
        // default value and lambda (DO NOT USE METHOD REFERENCE)

        Integer amountOfStreamElements = accounts.stream()
                .map(a -> 1)
                .reduce(0, (n1, n2) -> n1 + n2);

        System.out.println(amountOfStreamElements);

        System.out.println("--------------------------------");

        // 3 - Concatenate all last names into a single string, separated by commas, using reduce() method

        String lastNamesString = accounts.stream()
                .map(a -> a.getLastName())
                .reduce((a, b) -> a + "," + b).get();

//        String lastNamesStringWithCollect = accounts.stream()
//                .map(a -> a.getLastName())
//                .collect(Collectors.joining(","));

        System.out.println(lastNamesString);

        System.out.println("--------------------------------");
    }
}

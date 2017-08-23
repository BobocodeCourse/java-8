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

        // 1 - Calculate sum of all account balances using reduce() method that receives two parameters:
        // default value and lambda (DO NOT USE METHOD REFERENCE)
        System.out.println("Calculate sum of all account balances using reduce() method that receives two parameters:");
        System.out.println("default value and lambda (DO NOT USE METHOD REFERENCE)");
        double sumAllAccountBalances = accounts.stream()
                .mapToDouble(account -> account.getBalance().doubleValue())
                .reduce(0, (a, b) -> a + b);
        System.out.println(sumAllAccountBalances);
        System.out.println("**************************************************************************");

        // 2 - Compute the amount of all stream elements using reduce methods that receives two parameters
        // default value and lambda (DO NOT USE METHOD REFERENCE)
        System.out.println("Compute the amount of all stream elements using reduce methods that receives two parameters");
        System.out.println("default value and lambda (DO NOT USE METHOD REFERENCE)");
        Integer getAmountAllStreamElement = accounts.stream()
                .map(c -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(getAmountAllStreamElement);
        System.out.println("**************************************************************************");

        // 3 - Concatenate all last names into a single string, separated by commas, using reduce() method
        System.out.println("Concatenate all last names into a single string, separated by commas, using reduce() method");
        Optional<String> concatenateLastNamesSeparatedCommas = accounts.stream()
                .map(Account::getLastName)
                .reduce((lastName1, lastName2) -> lastName1 + "," + lastName2);
        System.out.println(concatenateLastNamesSeparatedCommas);

    }
}

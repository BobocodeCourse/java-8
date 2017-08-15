package com.bobocode;


import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Using Stream API, lambdas, and predefined functional interfaces implement the code according to requirements
 */
public class StreamTask_Collecting {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();

        // 1 - Find a set of account owner's names(first name) that have a length <= 4
        accounts.stream()
                .filter(a -> a.getFirstName().length() <= 4)
                .collect(Collectors.toSet())
                .forEach(a -> System.out.println(a.getFirstName()));

        System.out.println("--------------------------------");

        // 2 - Group all accounts by its email providers. (You can consider as an email provider
        // everything that goes after @ sign

        accounts.stream()
                .collect(Collectors.groupingBy(a -> a.getEmail().split("@")[1]))
                .entrySet()
                .stream()
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        // 3 - Find the richest guy

        Optional<Account> theRichestGuy = accounts.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Account::getBalance)));

        System.out.println(theRichestGuy);

        Optional<Account> theRichestGuy2 = accounts.stream()
                .max(Comparator.comparing(Account::getBalance));

        System.out.println(theRichestGuy2);

        System.out.println("--------------------------------");

        // 4 - Find the richest guy for each email provider

        accounts.stream()
                .collect(Collectors.groupingBy(a -> a.getEmail().split("@")[1],
                        Collectors.maxBy(Comparator.comparing(Account::getBalance))))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        // 5 - Split accounts by their balance (those who have more than $90 000.00, and those who don't)

        accounts.stream()
                .collect(Collectors.partitioningBy(a -> a.getBalance().compareTo(BigDecimal.valueOf(90000.00)) == 1))
                .entrySet()
                .forEach(System.out::println);
    }
}

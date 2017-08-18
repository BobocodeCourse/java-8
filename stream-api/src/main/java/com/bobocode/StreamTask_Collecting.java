package com.bobocode;


import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Using Stream API, lambdas, and predefined functional interfaces implement the code according to requirements
 */
public class StreamTask_Collecting {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();

        accounts.forEach(System.out::println);
        System.out.println();

        // 1 - Find a set of account owner's names(first name) that have a length <= 4
        accounts.stream()
                .filter(account -> account.getFirstName().length()<=4)
                .forEach(System.out::println);
        System.out.println();

        // 2 - Group all accounts by its email providers. (You can consider as an email provider
        // everything that goes after @ sign
        Map<String, List<String>> mapAccounts = accounts.stream()
                .collect(groupingBy(account -> account.getEmail().split("@")[1], mapping(Account::getFirstName, toList())));
        System.out.println(mapAccounts);

        // 3 - Find the richest guy
        Optional<Account> maxAccount = accounts.stream()
                .max(comparing(Account::getBalance));

        System.out.print("\nRichest guy: " );
        maxAccount.map(Account::getFirstName).ifPresent(System.out::println);
        System.out.println(maxAccount);

        // 4 - Find the richest guy for each email provider
        Map<String, Optional<Account>> mapRichestsEmails = accounts.stream()
                .collect(groupingBy(account -> account.getEmail().split("@")[1], maxBy(comparing(Account::getBalance))));

        System.out.println("\nRichest emails:");
        mapRichestsEmails.values().forEach(System.out::println);

        // 5 - Split accounts by their balance (those who have more than $90 000.00, and those who don't)
        Map<Boolean, List<String>> partAccounts = accounts.stream()
                .collect(partitioningBy(account -> account.getBalance().intValue()>90000, mapping(Account::getFirstName, toList())));
        System.out.println("\nPartition accounts by value of ballance(90000): " + partAccounts);
    }

}

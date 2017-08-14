package com.bobocode;


import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.time.Month;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * Collecting stream elements with method collect(). that receives a Collector instance as input parameter.
 * Methods collect transform a stream into a real collection like List, or a Map. A Collector is a complex structure,
 * that describes a collecting logic. It provides an instruction about how elements should collected, and what collection
 * should be used.
 *
 * Basically method collect<Collector c> allow you to declare how do you want to collect your stream elements. Simplest
 * example is collecting all elements to list. However this mechanism is very powerful, and allows to perform various
 * complex data transformations. E.g. "Group all account by it's birthday month", if you want to get a Map<Month, Account>
 * - a map where a key is a month, and a value is an account instance
 */
public class StreamExamples_Collecting {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();

        System.out.println("\nMap accounts into emails, filter gmail accounts, collect emails into List: ");
        List<String> accountEmails = accounts.stream()
                .map(Account::getEmail)
                .filter(email -> email.endsWith("gmail.com"))
                .collect(toList());
        System.out.println(accountEmails);

        // You can also collect elements using more sophisticated collectors
        System.out.println("\nGroup accounts by birthday month: ");
        Map<Month, List<Account>> accountsByBirthdayMonthMap = accounts.stream()
                .collect(groupingBy(account -> account.getBirthday().getMonth()));
        System.out.println(accountsByBirthdayMonthMap);

        // Collecting elements allows a lot of customization, for instance you can configure groupingBy() collector
        System.out.println("\nGroup account first names by birthday month: ");
        Map<Month, List<String>> accountFirstNamesyBirthdayMonth = accounts.stream()
                .collect(groupingBy(a -> a.getBirthday().getMonth(), mapping(Account::getFirstName, toList())));

        Map<Boolean, List<String>> googleEmailAccounts = accounts.stream()
                .collect(partitioningBy(a -> a.getEmail().endsWith("gmail.com"), mapping(Account::getFirstName, toList())));

        System.out.println(googleEmailAccounts);

        System.out.println(accountFirstNamesyBirthdayMonth);
    }
}

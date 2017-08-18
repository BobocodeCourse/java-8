package com.bobocode;


import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

/**
 * Using Stream API, lambdas, and predefined functional interfaces implement the code according to requirements
 */
public class StreamTask_Collecting {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();

        // 1 - Find a set of account owner's names(first name) that have a length <= 4
        System.out.println("Find a set of account owner's names(first name) that have a length <= 4");
        accounts.stream()
                .map(Account::getFirstName)
                .filter(name -> name.length() <= 4)
                .forEach(System.out::println);
        System.out.println("**************************************************************************");

        // 2 - Group all accounts by its email providers. (You can consider as an email provider
        // everything that goes after @ sign

        System.out.println("Group all accounts by its email providers. " +
                "(You can consider as an email provider everything that goes after @ sign");
        Map<String, List<Account>> groupAccountsByEmail = accounts.stream()
                .collect(groupingBy(account -> account.getEmail()
                        .substring(account.getEmail().indexOf("@") + 1)));
        System.out.println(groupAccountsByEmail);

        Map<String, List<Account>> groupAccountsByEmail2 = accounts.stream()
                .collect(groupingBy(account -> account.getEmail().replaceAll(".+\\@", "")));
        System.out.println(groupAccountsByEmail2);
        System.out.println("**************************************************************************");


        // 3 - Find the richest guy
        System.out.println("Find the richest guy");
        Optional<Account> getRichestGuy = accounts.stream()
                .max(comparing(Account::getBalance));
        System.out.println(getRichestGuy);
        System.out.println("**************************************************************************");


        // 4 - Find the richest guy for each email provider
        System.out.println("Find the richest guy for each email provider");
//        accounts.stream()
//                 .collect(groupingBy(account->account.getEmail().replaceAll(".+\\@","")),
//                         maxBy(comparing(Account::getBalance)));
        System.out.println("**************************************************************************");

        // 5 - Split accounts by their balance (those who have more than $90 000.00, and those who don't)
        System.out.println("Split accounts by their balance (those who have more than $90 000.00, and those who don't)");
        BigDecimal bigDecimal = new BigDecimal(90000);
        Map<Integer, List<BigDecimal>> splitBalanceByBigDecimal = accounts.stream()
                .map(Account::getBalance)
                .collect(groupingBy(balance -> balance.compareTo(bigDecimal)));
        System.out.println(splitBalanceByBigDecimal);
        System.out.println("**************************************************************************");
        //тут хочу выводить именно акаунты, а не только балансы. не могу понять как

    }
}

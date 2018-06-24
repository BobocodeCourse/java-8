package com.bobocode;


import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.List;
import java.util.function.Predicate;

public class Filtering {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        printAccountsThatHaveGoogleEmail(accounts);
    }

    /**
     * To filter accounts we use an instance of @{@link Predicate} that checks if an email is gmail based
     * @param accounts
     */
    private static void printAccountsThatHaveGoogleEmail(List<Account> accounts) {
        accounts.stream()
                .filter(a -> a.getEmail().endsWith("gmail.com"))
                .forEach(System.out::println);
    }
}

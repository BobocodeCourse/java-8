package com.bobocode.util;

import com.bobocode.model.Account;
import com.bobocode.model.Company;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDataProvider {

    public static List<Account> generateAccountList() {
        List<Account> accounts = new ArrayList<>(6);
        accounts.add(new Account(1L, "Will", "Smith", "wsmith@gmail.com",
                LocalDate.of(1968, 8, 25), LocalDateTime.now(), BigDecimal.valueOf(104065.25)));
        accounts.add(new Account(2L, "Tom", "Hanks", "thanks@gmail.com",
                LocalDate.of(1956, 7, 9), LocalDateTime.now(), BigDecimal.valueOf(93065.25)));
        accounts.add(new Account(3L, "Russell", "Crowe", "rcrowe@gmail.com",
                LocalDate.of(1964, 4, 7), LocalDateTime.now(), BigDecimal.valueOf(87641.98)));
        accounts.add(new Account(4L, "Robert", "Downey", "rdowney@yahoo.com",
                LocalDate.of(1965, 4, 9), LocalDateTime.now(), BigDecimal.valueOf(152345)));
        accounts.add(new Account(5L, "Robert", "De Niro", "deniro@outlook.com",
                LocalDate.of(1943, 8, 17), LocalDateTime.now(), BigDecimal.valueOf(67065.45)));
        accounts.add(new Account(6L, "Metthew", "Perry", "mperry@gmail.com",
                LocalDate.of(1969, 8, 19), LocalDateTime.now(), BigDecimal.valueOf(45678.12)));
        return accounts;
    }

    public static Account generateFakeAccount() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        Random random = new Random();


        Account fakeAccount = new Account();
        fakeAccount.setFirstName(person.getFirstName());
        fakeAccount.setLastName(person.getLastName());
        fakeAccount.setEmail(person.getEmail());
        fakeAccount.setBirthday(LocalDate.of(
                person.getDateOfBirth().getYear(),
                person.getDateOfBirth().getMonthOfYear(),
                person.getDateOfBirth().getDayOfMonth()));
        fakeAccount.setBalance(BigDecimal.valueOf(random.nextInt(200_000)));
        fakeAccount.setCreationDate(LocalDateTime.now());

        return fakeAccount;
    }

    public static Company generateFakeCompany() {
        Fairy fairy = Fairy.create();
        io.codearte.jfairy.producer.company.Company company = fairy.company();
        Random random = new Random();

        Company fakeCompany = new Company();
        fakeCompany.setName(company.getName());
        fakeCompany.setPhone("+380" + String.valueOf(random.nextInt(90_000_000)));

        return fakeCompany;
    }

}
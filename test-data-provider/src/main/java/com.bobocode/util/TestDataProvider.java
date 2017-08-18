package com.bobocode.util;

import com.bobocode.model.Account;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TestDataProvider {

    public static List<Account> generateAccountList(int qnt) {
        return Stream.generate(TestDataProvider::generateFakeAccount)
                .limit(qnt)
                .collect(toList());
    }

    public static List<Account> generateAccountList() {
        return Stream.generate(TestDataProvider::generateFakeAccount)
                .limit(10)
                .collect(toList());
    }

    public static Account generateFakeAccount(){
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
        fakeAccount.setCreationDate(LocalDateTime.of(random.nextInt(5)+2010, 1,1,1,1));

        return fakeAccount;
    }


}
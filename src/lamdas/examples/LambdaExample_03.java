package lamdas.examples;

import lamdas.Condition;
import lamdas.Operation;
import model.Account;
import util.TestDataProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.time.Period.between;

/**
 * Behavior parameterization with Lambdas.
 *
 * Lambdas allow you to provide only required specific code, and make code clear. Lambda is an anonymous method, but
 * it is always assigned to some interface. It can be assigned to an interface variable, or passes as method argument.
 * Lambda should be always compatible with its target type, which is specified by some interface. Such interface
 * is called Functional interface, because it represents only one function that is defined by one abstract method.
 *
 * See LambdaExample_04.java for different target typing examples
 *
 */
public class LambdaExample_03 {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();
        processAccountWithoutLambdas(accounts,
                a -> between(a.getCreationDate(), LocalDate.now()).getYears() > 4,
                a -> a.setBalance(a.getBalance().add(BigDecimal.valueOf(50))));
    }

    private static void processAccountWithoutLambdas(List<Account> accounts, Condition<Account> condition,
                                                     Operation<Account> operation) {
        for (Account account : accounts) {
            if (condition.isTrue(account)) {
                operation.apply(account);
            }
        }
    }
}

package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.HashSet;
import java.util.List;

public class NotifyAccountTest {

    @Test
    public void testSent() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "3sdfdfsdf"),
                new Account("423", "Petr Arsentev", "dfwerg342")
        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("123", "Petr Arsentev", "3sdfdfsdf"),
                        new Account("423", "Petr Arsentev", "dfwerg342")
                )
        );
        Assert.assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void testSentRemoveDuplicate() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "3sdfdfsdf"),
                new Account("423", "Petr Arsentev", "dfwerg342"),
                new Account("123", "Petr Arsentev", "dfwerg342")
        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("123", "Petr Arsentev", "3sdfdfsdf"),
                        new Account("423", "Petr Arsentev", "dfwerg342")
                )
        );
        Assert.assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}
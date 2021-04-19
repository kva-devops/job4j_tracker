package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    }
}
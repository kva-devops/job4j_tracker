package ru.job4j.collection;

import java.util.List;
import java.util.HashSet;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account elem : accounts) {
            rsl.add(elem);
        }
        return rsl;
    }
}

package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mailList = new HashMap<>();
        mailList.put("tribuna87@mail.ru", "Vladimir");
        mailList.put("username@mail.ru", "Username");
        for (String key : mailList.keySet()) {
            String value = mailList.get(key);
            System.out.println(key + " = " + value);
        }

    }
}

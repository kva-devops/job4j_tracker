package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> byName = person -> person.getName().equals(key);
        Predicate<Person> bySurname = person -> person.getSurname().equals(key);
        Predicate<Person> byAddress = person -> person.getAddress().equals(key);
        Predicate<Person> byPhone = person -> person.getPhone().equals(key);
        Predicate<Person> combine = byName.or(bySurname).or(byAddress).or(byPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}

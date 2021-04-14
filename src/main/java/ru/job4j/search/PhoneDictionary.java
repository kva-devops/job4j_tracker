package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

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
        Predicate<Person> combine = person ->
                byName.test(person) || bySurname.test(person) || byAddress.test(person)
                || byPhone.test(person);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}

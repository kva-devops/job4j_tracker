package ru.job4j.search;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.ArrayList;

public class PhoneDictionaryTest {

    @Test
    public void testFind() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr",
                        "Arsentev",
                        "+78808888",
                        "Bryansk")
        );
        ArrayList<Person> result = phones.find("Petr");
        String rsl = result.get(0).getName();
        String expect = "Petr";
        Assert.assertThat(expect, is(rsl));
    }

    @Test
    public void testNotFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr",
                        "Arsentev",
                        "+743234234",
                        "Bryansk")
        );
        ArrayList<Person> result = phones.find("Piter");
        Assert.assertThat(result, IsEmptyCollection.empty());
    }

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "111333", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        Assert.assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "111333", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Arsentev");
        Assert.assertThat(persons.get(0).getPhone(), is("111333"));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "111333", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("111333");
        Assert.assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "111333", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Bryansk");
        Assert.assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenFindByNameResultFalse() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "111333", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petrov");
        Assert.assertThat(persons.isEmpty(), is(true));
    }
}
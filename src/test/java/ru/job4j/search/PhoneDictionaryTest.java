package ru.job4j.search;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.ArrayList;

public class PhoneDictionaryTest {

    @Test
    public void testFind() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr",
                        "Arsentev",
                        "+78808888",
                        "Bryansk")
        );
        var result = phones.find("Petr");
        var rsl = result.get(0).getName();
        var expect = "Petr";
        Assert.assertThat(expect, is(rsl));
    }

    @Test
    public void testNotFound() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr",
                        "Arsentev",
                        "+743234234",
                        "Bryansk")
        );
        var result = phones.find("Piter");
        Assert.assertThat(result, IsEmptyCollection.empty());
    }

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "111333", "Bryansk")
        );
        var persons = phones.find("Petr");
        Assert.assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "111333", "Bryansk")
        );
        var persons = phones.find("Arsentev");
        Assert.assertThat(persons.get(0).getPhone(), is("111333"));
    }

    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "111333", "Bryansk")
        );
        var persons = phones.find("111333");
        Assert.assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "111333", "Bryansk")
        );
        var persons = phones.find("Bryansk");
        Assert.assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenFindByNameResultFalse() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "111333", "Bryansk")
        );
        var persons = phones.find("Petrov");
        Assert.assertThat(persons.isEmpty(), is(true));
    }
}
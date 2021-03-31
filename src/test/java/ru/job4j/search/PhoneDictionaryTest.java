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
}
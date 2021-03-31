package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
        assertThat(result.get(0).getSurname(), is("Arsentev"));
    }
}
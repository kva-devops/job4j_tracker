package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenAscName() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenAscAge() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 31));
        users.add(new User("Petr", 29));
        users.add(new User("Petr", 30));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Petr", 29)));
        assertThat(it.next(), is(new User("Petr", 30)));
        assertThat(it.next(), is(new User("Petr", 31)));
    }


    @Test
    public void whenComparePetrVSIvanExpectGreaterZero() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparePetrVSIvanExpectLessZero() {
        int rsl = new User("Ivan", 31)
                .compareTo(
                        new User("Petr", 32)
                );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparePetrVSIvanExpectEqualZero() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Petr", 32)
                );
        assertThat(rsl, equalTo(0));
    }
}
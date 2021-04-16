package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfilesTest {

    @Test
    public void whenHasProfiles() {
        List<Address> expect = Arrays.asList(
                new Address("Moscow", "Lenina", 5, 100),
                new Address("Moscow", "Stalina", 7, 334),
                new Address("Vladivostok", "Pushkina", 34, 13)
        );
        List<Profile> clients = Arrays.asList(
                new Profile(new Address(
                        "Moscow", "Lenina", 5, 100)),
                new Profile(new Address(
                        "Moscow", "Stalina", 7, 334)),
                new Profile(new Address(
                        "Vladivostok", "Pushkina", 34, 13))
        );
        List<Address> result = Profiles.collect(clients);
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void whenHasNotProfiles() {
        List<Address> expect = new ArrayList<>();
        List<Profile> clients = new ArrayList<>();
        List<Address> result = Profiles.collect(clients);
        Assert.assertThat(result, is(expect));
    }
}
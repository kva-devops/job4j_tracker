package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class PassportOfficeTest {

    @Test
    public void testAdd() {
        Citizen citizen = new Citizen("3234", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Assert.assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void testAddDuplicate() {
        Citizen citizen = new Citizen("3234", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Assert.assertThat(office.add(citizen), is(false));
    }
}
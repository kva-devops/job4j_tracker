package ru.job4j.pojo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class LicenseTest {

    @Test
    public void testTestEquals() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        Assert.assertThat(first, is(second));
    }
}
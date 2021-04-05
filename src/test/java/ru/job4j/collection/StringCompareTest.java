package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;

public class StringCompareTest {

    @Test
    public void whenStringsEqualsThenZero() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare("Ivanov", "Ivanov");
        Assert.assertThat(rsl, is(0));
    }

    @Test
    public void whenStringEqualsButLeftLessThanRightThenNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare("Ivanov", "Ivanova");
        Assert.assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenLeftGreaterRightThenPositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare("Petrov", "Ivanova");
        Assert.assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenSecondCharLeftGreaterSecondCharRightThenPositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare("Petrov", "Patrov");
        Assert.assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenSecondCharLeftLessSecondCharRightThenNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare("Patrova", "Petrov");
        Assert.assertThat(rsl, lessThan(0));
    }

}
package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.List;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void testSortWhenAscOrder() {
        List<String> input = List.of(
                "k2",
                "k2/sk1",
                "k2/sk1/ssk2",
                "k2/sk1/ssk1",
                "k1/sk1",
                "k1"
        );
        List<String> except = List.of(
                "k1",
                "k1/sk1",
                "k2",
                "k2/sk1",
                "k2/sk1/ssk1",
                "k2/sk1/ssk2"
        );
        Departments.sortAsc(input);
        Assert.assertThat(except, is(input));
    }

    @Test
    public void testSortWhenDescOrder() {
        List<String> input = List.of(
                "k1",
                "k1/sk1",
                "k2/sk1/ssk2",
                "k2/sk1/ssk1",
                "k2/sk1",
                "k2"
        );
        List<String> except = List.of(
                "k2",
                "k2/sk1",
                "k2/sk1/ssk1",
                "k2/sk1/ssk2",
                "k1",
                "k1/sk1"
        );
        Departments.sortDesc(input);
        Assert.assertThat(except, is(input));
    }
}
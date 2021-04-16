package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.List;

public class FlatMapTest {

    @Test
    public void whenHasArrayThenHasList() {
        List<Integer> expect = List.of(1, 2, 3, 4);
        Integer[][] intArr = new Integer[][] {
                new Integer[] {1, 2},
                new Integer[] {3, 4}
        };
        List<Integer> result = FlatMap.convert(intArr);
        Assert.assertThat(expect, is(result));
    }
}
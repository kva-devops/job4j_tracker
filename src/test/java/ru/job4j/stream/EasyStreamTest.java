package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.List;

public class EasyStreamTest {

    @Test
    public void whenEmptySource() {
        var rsl = EasyStream.of(List.of())
                .collect();
        Assert.assertThat(rsl, is(List.of()));
    }

    @Test
    public void whenFilledSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .collect();
        Assert.assertThat(rsl, is(List.of(1, 2, 3)));
    }

    @Test
    public void whenFilteredSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .filter(e -> e == 2)
                .collect();
        Assert.assertThat(rsl, is(List.of(2)));
    }

    @Test
    public void whenMappedSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .map(e -> e * 2)
                .collect();
        Assert.assertThat(rsl, is(List.of(2, 4, 6)));
    }

    @Test
    public void whenFilteredMappedSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .filter(e -> e == 2)
                .map(e -> e * 2)
                .collect();
        Assert.assertThat(rsl, is(List.of(4)));
    }

    @Test
    public void whenMappedFilteredSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .map(e -> e * 2)
                .filter(e -> e == 2)
                .collect();
        Assert.assertThat(rsl, is(List.of(2)));
    }

    @Test
    public void whenMultiSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3, 4, 5))
                .filter(e -> e >= 2)
                .filter(e -> e <= 4)
                .collect();
        Assert.assertThat(rsl, is(List.of(2, 3, 4)));
    }
}
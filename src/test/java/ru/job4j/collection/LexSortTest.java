package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;

public class LexSortTest {

    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task",
                "1. Task",
                "2. Task"
        };
        String[] output = {
                "1. Task",
                "2. Task",
                "10. Task"
        };
        Arrays.sort(input, new LexSort());
        Assert.assertThat(input, is(output));
    }
}
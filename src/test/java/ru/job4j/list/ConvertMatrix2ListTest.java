package ru.job4j.list;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.List;

public class ConvertMatrix2ListTest {

    @Test
    public void testToList() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = list.toList(input);
        Assert.assertThat(result, is(expect));
    }
}
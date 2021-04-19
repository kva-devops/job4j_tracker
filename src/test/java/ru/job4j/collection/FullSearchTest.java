package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class FullSearchTest {

    @Test
    public void testExtractNumber() {
        List<Task> tasks = List.of(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        Set<String> expected = new HashSet<>(List.of("1", "2"));
        assertThat(FullSearch.extractNumber(tasks), is(expected));

    }
}
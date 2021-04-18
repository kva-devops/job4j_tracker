package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.ArrayList;
import java.util.List;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student(28, "Masha"));
        input.add(new Student(128, "Petya"));
        List<Student> expect = List.of(
                new Student(128, "Petya"),
                new Student(28, "Masha")
        );
        Assert.assertThat(StudentLevel.levelOf(input, 20), is(expect));
    }

    @Test
    public void whenNullOnly() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expect = List.of();
        Assert.assertThat(StudentLevel.levelOf(input, 100), is(expect));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(28, "Petya"));
        List<Student> expect = List.of(new Student(28, "Petya"));
        Assert.assertThat(StudentLevel.levelOf(input, 10), is(expect));
    }
}
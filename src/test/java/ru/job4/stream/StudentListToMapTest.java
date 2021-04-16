package ru.job4.stream;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.stream.Student;
import ru.job4j.stream.StudentListToMap;

import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentListToMapTest {

    @Test
    public void testConvert() {
        List<Student> list = Arrays.asList(
                new Student(10, "Ivanov"),
                new Student(30, "Petrov"),
                new Student(50, "Sidorov"),
                new Student(10, "Ivanov")
        );
        Map<String, Student> expect = new HashMap<>();
        expect.put("Ivanov", new Student(10, "Ivanov"));
        expect.put("Petrov", new Student(30, "Petrov"));
        expect.put("Sidorov", new Student(50, "Sidorov"));

        Map<String, Student> result = StudentListToMap.convert(list);
        Assert.assertThat(result, is(expect));
    }
}
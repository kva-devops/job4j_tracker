package ru.job4j.stream;

import ru.job4j.stream.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentListToMap {
    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        value -> value,
                        (student1, student2) -> student1
                ));
    }
}

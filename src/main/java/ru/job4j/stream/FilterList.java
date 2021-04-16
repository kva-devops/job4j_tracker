package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterList {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, -4, 5, -6);
        System.out.println(list);
        List<Integer> result = list.stream().filter(num -> num > 0).collect(Collectors.toList());
        System.out.println(result);
    }
}

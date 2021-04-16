package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

    public static List<Integer> convert(Integer[][] intArr) {
        return  Arrays.stream(intArr)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}

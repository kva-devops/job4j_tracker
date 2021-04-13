package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDesc = (left, right) -> {
            System.out.println("compare - " + right + " : " + left);
            return right.compareTo(left);
        };
        List<String> listArr = Arrays.asList("test1", "test2", "test3", "test0", "test4");
        System.out.println(listArr);
        listArr.sort(cmpDesc);
        System.out.println(listArr);
    }
}

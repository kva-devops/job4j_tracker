package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] strBeforeSplitLeft = left.split(". ");
        String[] strBeforeSplitRight = right.split(". ");
        int leftInt = Integer.parseInt(strBeforeSplitLeft[0]);
        int rightInt = Integer.parseInt(strBeforeSplitRight[0]);
        return Integer.compare(leftInt, rightInt);
    }
}

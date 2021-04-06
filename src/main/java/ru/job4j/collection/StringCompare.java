package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rslCmpString = 0;
        int rslSizeMinStr = Math.min(left.length(), right.length());
        for (int i = 0; i < rslSizeMinStr; i++) {
            rslCmpString = Character.compare(left.charAt(i), right.charAt(i));
            if (rslCmpString != 0) {
                break;
            }
        }
        if (rslCmpString == 0) {
            rslCmpString = Integer.compare(left.length(), right.length());
        }
        return rslCmpString;

    }
}
package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        List<Character> leftList = new ArrayList<>();
        List<Character> rightList = new ArrayList<>();
        for (int index = 0; index < left.length(); index++) {
            leftList.add(index, left.charAt(index));
        }
        for (int index = 0; index < right.length(); index++) {
            rightList.add(index, right.charAt(index));
        }
        int lengthLeftList = leftList.size();
        int lengthRightList = rightList.size();
        int rslCmpString = 0;
        int rslCompareSizeList = lengthLeftList - lengthRightList;
        if (rslCompareSizeList == 0) {
            for (int i = 0; i < lengthLeftList; i++) {
                rslCmpString = Character.compare(leftList.get(i), rightList.get(i));
                if (rslCmpString != 0) {
                    break;
                }
            }
        } else if (rslCompareSizeList > 0) {
            for (int i = 0; i < lengthRightList; i++) {
                rslCmpString = Character.compare(leftList.get(i), rightList.get(i));
                if (rslCmpString != 0) {
                    break;
                } else {
                    rslCmpString = 1;
                }
            }
        } else {
            for (int i = 0; i < lengthLeftList; i++) {
                rslCmpString = Character.compare(leftList.get(i), rightList.get(i));
                if (rslCmpString != 0) {
                    break;
                } else {
                    rslCmpString = -1;
                }
            }
        }
        return rslCmpString;
    }
}
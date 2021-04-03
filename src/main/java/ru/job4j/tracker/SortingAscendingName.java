package ru.job4j.tracker;

import java.util.Comparator;

public class SortingAscendingName implements Comparator<Item> {
    public int compare(Item o1, Item o2) {
        return CharSequence.compare(o1.getName(), o2.getName());
    }
}

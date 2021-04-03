package ru.job4j.tracker;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortingAscending implements Comparator<Item> {
    public int compare(Item o1, Item o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}

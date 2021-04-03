package ru.job4j.tracker;

import java.util.Comparator;
import java.util.List;

public class SortItemDescendingOrder implements UserAction {
    private final Output out;

    public SortItemDescendingOrder(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Sorting by ID - Descending Order";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Sorting by ID Descending Order ===");
        List<Item> buffer = tracker.sortDescendId();
        for (Item element : buffer) {
            out.println(element);
        }
        return true;
    }
}

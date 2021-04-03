package ru.job4j.tracker;

import java.util.List;

public class SortItemDescendingOrderName implements UserAction {
    private final Output out;

    public SortItemDescendingOrderName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Sorting by Name - Descending Order";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Sorting by Name Descending Order ===");
        List<Item> buffer = tracker.sortDescendName();
        for (Item element : buffer) {
            out.println(element);
        }
        return true;
    }
}

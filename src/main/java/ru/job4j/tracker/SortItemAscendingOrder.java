package ru.job4j.tracker;

import java.util.List;

public class SortItemAscendingOrder implements UserAction {
    private final Output out;

    public SortItemAscendingOrder(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Sorting by ID - Ascending Order";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Sorting by ID Ascending Order ===");
        List<Item> buffer = memTracker.sortAscendId();
        for (Item element : buffer) {
            out.println(element);
        }
        return true;
    }
}

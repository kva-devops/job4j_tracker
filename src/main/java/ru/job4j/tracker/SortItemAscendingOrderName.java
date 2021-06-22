package ru.job4j.tracker;

import java.util.List;

public class SortItemAscendingOrderName implements UserAction {
    private final Output out;

    public SortItemAscendingOrderName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Sorting by Name - Ascending Order";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Sorting by Name Ascending Order ===");
        List<Item> buffer = memTracker.sortAscendName();
        for (Item element : buffer) {
            out.println(element);
        }
        return true;
    }

}

package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class SortItemByOrderMode implements UserAction {
    private final Output out;

    public SortItemByOrderMode(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Sorting by Mode - Name or Id field, Asc or Desc order";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Sorting by Mode ===");
        String fieldName = input.askStr("Choice field for order: NAME or ID: ");
        String mode = input.askStr("Choice mode: ASC or DESC");
        List<Item> buffer = new ArrayList<>();
        if ("name".equals(fieldName) || "id".equals(fieldName)
        && "asc".equals(mode) || "desc".equals(mode)) {
            buffer = memTracker.findAllByOrder(fieldName, mode);
        } else {
            System.out.println("field: NAME or ID, mode: ASC or DESC");
        }
        for (Item element : buffer) {
            out.println(element);
        }
        return true;
    }
}

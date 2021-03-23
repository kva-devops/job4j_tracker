package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== All list items ===");
        Item[] buffer = tracker.findAll();
        for (Item element : buffer) {
            System.out.println(element);
        }
        return true;
    }
}

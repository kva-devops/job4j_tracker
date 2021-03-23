package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== All list items ===");
        Item[] buffer = tracker.findAll();
        for (Item element : buffer) {
            out.println(element);
        }
        return true;
    }
}

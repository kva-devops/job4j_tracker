package ru.job4j.tracker;

public class FindByIDAction implements UserAction {
    private final Output out;

    public FindByIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by ID ===");
        int id = input.askInt("Enter ID for find item: ");
        Item result = tracker.findById(id);
        if (result != null) {
            out.println("Result: " + result);
        } else {
            out.println("Don't find. Try again.");
        }
        return true;
    }
}

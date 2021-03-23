package ru.job4j.tracker;

public class FindByIDAction implements UserAction {
    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by ID ===");
        int id = input.askInt("Enter ID for find item: ");
        Item result = tracker.findById(id);
        if (result != null) {
            System.out.println("Result: " + result);
        } else {
            System.out.println("Don't find. Try again.");
        }
        return true;
    }
}

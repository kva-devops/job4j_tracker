package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by Name ===");
        String nameFind = input.askStr("Enter NAME for find item: ");
        Item[] result = tracker.findByName(nameFind);
        if (result.length > 0) {
            for (Item elem : result) {
                System.out.println(elem);
            }
        } else {
            System.out.println("Don't find items");
        }
        return true;
    }
}

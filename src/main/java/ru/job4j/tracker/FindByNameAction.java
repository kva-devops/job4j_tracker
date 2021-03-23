package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Name ===");
        String nameFind = input.askStr("Enter NAME for find item: ");
        Item[] result = tracker.findByName(nameFind);
        if (result.length > 0) {
            for (Item elem : result) {
                out.println(elem);
            }
        } else {
            out.println("Don't find items");
        }
        return true;
    }
}

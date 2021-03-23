package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter ID item for search: ");
        String newName = input.askStr("Enter new NAME: ");
        Item objAfter = new Item(newName);
        if (tracker.replace(id, objAfter)) {
            out.println("Editing is successful");
        } else {
            out.println("Editing is not successful");
        }
        return true;
    }
}

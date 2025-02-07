package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter ID item for delete: ");
        if (memTracker.delete(id)) {
            out.println("Deleting is successful");
        } else {
            out.println("Deleting is not successful");
        }
        return true;
    }
}

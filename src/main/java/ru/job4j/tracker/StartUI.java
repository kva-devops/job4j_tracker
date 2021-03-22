package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name:");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All list items ===");
                Item[] buffer = tracker.findAll();
                for (Item element : buffer) {
                    System.out.println(element);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                int id = input.askInt("Enter ID item for search: ");
                String newName = input.askStr("Enter new NAME: ");
                Item objAfter = new Item(newName);
                if (tracker.replace(id, objAfter)) {
                    System.out.println("Editing is successful");
                } else {
                    System.out.println("Editing is not successful");
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                int id = input.askInt("Enter ID item for delete: ");
                if (tracker.delete(id)) {
                    System.out.println("Deleting is successful");
                } else {
                    System.out.println("Deleting is not successful");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by ID ===");
                int id = input.askInt("Enter ID for find item: ");
                Item result = tracker.findById(id);
                if (result != null) {
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Don't find. Try again.");
                }
            } else if (select == 5) {
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
            } else if (select == 6) {
                run = false;
                System.out.println("Goodbye!");
            }

        }
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by ID");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
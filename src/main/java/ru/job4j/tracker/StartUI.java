package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
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
                System.out.println("Enter ID item for search: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter new NAME: ");
                String newName = scanner.nextLine();
                Item objAfter = new Item(newName);
                if (tracker.replace(id, objAfter)) {
                    System.out.println("Editing is successful");
                } else {
                    System.out.println("Editing is not successful");
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.println("Enter ID item for delete: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Deleting is successful");
                } else {
                    System.out.println("Deleting is not successful");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by ID ===");
                System.out.println("Enter ID for find item: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item result = tracker.findById(id);
                if (result != null) {
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Don't find. Try again.");
                }
            } else if (select == 5) {
                System.out.println("=== Find item by Name ===");
                System.out.println("Enter NAME for find item: ");
                String nameFind = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
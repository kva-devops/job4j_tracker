package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {

    public static void main(String[] args) {
        Tracker obj1 = new Tracker();
        obj1.add(new Item("Ivan"));
        obj1.add(new Item("Stepan"));
        obj1.add(new Item("Alex"));
        System.out.println("All items -> " + Arrays.toString(obj1.findAll()));
        System.out.println("Find by name 'Ivan' -> " + Arrays.toString(obj1.findByName("Ivan")));
        System.out.println("Find by ID '2' -> " + obj1.findById(2));
    }
}

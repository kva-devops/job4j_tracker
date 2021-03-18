package ru.job4j.tracker;

public class Item {
    private int id;

    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Item ob1 = new Item();
        Item ob2 = new Item("Something");
        Item ob3 = new Item("Else", 1233);
    }
}
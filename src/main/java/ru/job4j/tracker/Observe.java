package ru.job4j.tracker;

public interface Observe<Item> {
    void receive(Item item);
}

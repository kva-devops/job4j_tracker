package ru.job4j.tracker;

import java.util.List;

public interface Store extends AutoCloseable {
    void init();

    Item add(Item item);

    boolean replace(int id, Item item);

    boolean delete(int id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);

    List<Item> findAllByOrder(String fieldName, String mode);

    List<Item> sortAscendId();

    List<Item> sortDescendId();

    List<Item> sortDescendName();

    List<Item> sortAscendName();
}

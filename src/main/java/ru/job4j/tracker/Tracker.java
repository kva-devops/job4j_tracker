package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int size = 0;
        Item[] buff = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                buff[i] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(buff, size);
    }

    public Item[] findByName(String key) {
        Item[] buff = findAll();
        Item[] result = new Item[buff.length];
        int size = 0;
        for (int i = 0; i < buff.length; i++) {
            if (buff[i].getName().equals(key)) {
                result[i] = buff[i];
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}
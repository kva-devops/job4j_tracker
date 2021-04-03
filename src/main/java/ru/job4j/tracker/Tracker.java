package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tracker {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item elem : items) {
            if (elem.getName().equals(key)) {
                result.add(elem);
            }
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index >= 0) {
            items.set(index, item);
            item.setId(id);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index >= 0) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public List<Item> sortAscendId() {
        Collections.sort(items, new SortingAscending());
        return List.copyOf(items);
    }

    public List<Item> sortDescendId() {
        Collections.sort(items, new SortingAscending());
        Collections.reverse(items);
        return List.copyOf(items);
    }

    public List<Item> sortAscendName() {
        Collections.sort(items, new SortingAscendingName());
        return List.copyOf(items);
    }

    public List<Item> sortDescendName() {
        Collections.sort(items, new SortingAscendingName());
        Collections.reverse(items);
        return List.copyOf(items);
    }
}
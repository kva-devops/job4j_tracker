package ru.job4j.tracker.store;

import org.junit.Test;
import ru.job4j.tracker.HbmTracker;
import ru.job4j.tracker.Item;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CityStoreTest {

    @Test
    public void whenAddOneItemAndFindAll() {
        HbmTracker tracker = new HbmTracker();
        tracker.init();
        Item item = new Item("Item");
        tracker.add(item);
        List<Item> itemList = tracker.findAll();
        assertThat(itemList.get(0).getName(), is(item.getName()));
    }

    @Test
    public void whenAddOneItemAndReplaceThisAndFindAll() {
        HbmTracker tracker = new HbmTracker();
        tracker.init();
        Item item = new Item("Item");
        Item itemEdit = new Item("Item edit");
        tracker.add(item);
        tracker.replace(1, itemEdit);
        List<Item> itemList = tracker.findAll();
        assertThat(itemList.get(0).getName(), is(itemEdit.getName()));
    }

    @Test
    public void whenAddTwoItemAndDeleteOneAndFindAll() {
        HbmTracker tracker = new HbmTracker();
        tracker.init();
        Item item = new Item("Item");
        Item itemDelete = new Item("Item delete");
        tracker.add(item);
        tracker.add(itemDelete);
        tracker.delete(2);
        List<Item> itemList = tracker.findAll();
        assertThat(itemList.get(0).getName(), is(item.getName()));
    }

    @Test
    public void whenAddOneItemAndFindByNameThis() {
        HbmTracker tracker = new HbmTracker();
        tracker.init();
        Item item = new Item("Item");
        tracker.add(item);
        List<Item> itemList = tracker.findByName("Item");
        assertThat(itemList.get(0).getName(), is(item.getName()));
    }

    @Test
    public void whenAddTwoItemWithEqualNamesAndFindByNameThem() {
        HbmTracker tracker = new HbmTracker();
        tracker.init();
        Item item1 = new Item("Item");
        Item item2 = new Item("Item");
        tracker.add(item1);
        tracker.add(item2);
        List<Item> itemList = tracker.findByName("Item");
        assertThat(itemList.size(), is(2));
        assertThat(itemList.get(0).getId(), is(1));
        assertThat(itemList.get(1).getId(), is(2));
    }

    @Test
    public void whenAddOneItemAndFindByIdThis() {
        HbmTracker tracker = new HbmTracker();
        tracker.init();
        Item item = new Item("Item");
        tracker.add(item);
        Item result = tracker.findById(1);
        assertThat(result.getId(), is(item.getId()));
    }

    @Test
    public void whenAddThreeItemAndSortDescIdOrder() {
        HbmTracker tracker = new HbmTracker();
        tracker.init();
        Item item1 = new Item("c");
        Item item2 = new Item("b");
        Item item3 = new Item("a");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> resultList = tracker.sortDescendId();
        assertThat(resultList.get(0).getName(), is(item3.getName()));
    }

    @Test
    public void whenAddThreeItemAndSortAscIdOrder() {
        HbmTracker tracker = new HbmTracker();
        tracker.init();
        Item item1 = new Item("c");
        Item item2 = new Item("b");
        Item item3 = new Item("a");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> resultList = tracker.sortAscendId();
        assertThat(resultList.get(0).getName(), is(item1.getName()));
    }

    @Test
    public void whenAddThreeItemAndSortDescNameOrder() {
        HbmTracker tracker = new HbmTracker();
        tracker.init();
        Item item1 = new Item("c");
        Item item2 = new Item("b");
        Item item3 = new Item("a");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> resultList = tracker.sortDescendName();
        assertThat(resultList.get(0).getName(), is(item1.getName()));
    }

    @Test
    public void whenAddThreeItemAndSortAscNameOrder() {
        HbmTracker tracker = new HbmTracker();
        tracker.init();
        Item item1 = new Item("c");
        Item item2 = new Item("b");
        Item item3 = new Item("a");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> resultList = tracker.sortAscendName();
        assertThat(resultList.get(0).getName(), is(item3.getName()));
    }
}

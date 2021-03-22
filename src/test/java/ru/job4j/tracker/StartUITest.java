package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;

public class StartUITest {

    @Test
    public void testCreateItem() {
        String[] answers = {"Fix PS4"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expect = new Item("Fix PS4");
        Assert.assertThat(created.getName(), is(expect.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "replaced item"};
        Input input = new StubInput(answers);
        StartUI.replaceItem(input, tracker);
        Item replaced = tracker.findById(item.getId());
        Assert.assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        Input input = new StubInput(answers);
        StartUI.deleteItem(input, tracker);
        Assert.assertThat(
                tracker.findById(item.getId()),
                is(nullValue()));
    }
}
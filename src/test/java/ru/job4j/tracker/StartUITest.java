package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

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
}
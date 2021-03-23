package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;

public class StartUITest {

    @Test
    public void testCreateItem() {
        Input input = new StubInput(
                new String[] {"0", "Fix PS4", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        Item expect = new Item("Fix PS4");
        Assert.assertThat(created.getName(), is(expect.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "replaced item", "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {
                new EditAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        //StartUI.replaceItem(input, tracker);
        Item replaced = tracker.findById(item.getId());
        Assert.assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        //StartUI.deleteItem(input, tracker);
        Assert.assertThat(
                tracker.findById(item.getId()),
                is(nullValue()));
    }
}
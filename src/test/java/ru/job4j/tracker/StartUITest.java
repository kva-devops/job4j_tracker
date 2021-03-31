package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void testCreateItem() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "Fix PS4", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(input, tracker, actions);
        List<Item> created = tracker.findAll();
        Item expect = new Item("Fix PS4");
        assertThat(created.get(0).getName(), is(expect.getName()));
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        List<UserAction> actions = List.of(
                new ShowAllAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(input, tracker, actions);
        Assert.assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0.Show all items" + System.lineSeparator() +
                        "1.Exit program" + System.lineSeparator() +
                        "=== All list items ===" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0.Show all items" + System.lineSeparator() +
                        "1.Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "replaced item", "1"};
        Input input = new StubInput(answers);
        List<UserAction> actions = List.of(
                new EditAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(input, tracker, actions);
        Item replaced = tracker.findById(item.getId());
        Assert.assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        List<UserAction> actions = List.of(
                new DeleteAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(input, tracker, actions);
        //StartUI.deleteItem(input, tracker);
        Assert.assertThat(
                tracker.findById(item.getId()),
                is(nullValue()));
    }

    @Test
    public void whenFindByID() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new FindByIDAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        Assert.assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0.Find item by ID" + System.lineSeparator() +
                        "1.Exit program" + System.lineSeparator() +
                        "=== Find item by ID ===" + System.lineSeparator() +
                        "Result: " + item + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0.Find item by ID" + System.lineSeparator() +
                        "1.Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "new item", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        List<UserAction> actions = List.of(
                new FindByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        Assert.assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0.Find items by name" + System.lineSeparator() +
                        "1.Exit program" + System.lineSeparator() +
                        "=== Find item by Name ===" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0.Find items by name" + System.lineSeparator() +
                        "1.Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        Assert.assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0.Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertThat(out.toString(), is(
                "Menu" + ln
                + "0.Exit program" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu" + ln
                + "0.Exit program" + ln
        ));

    }
}
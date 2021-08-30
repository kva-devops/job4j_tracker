package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {

    public Connection init() {
        try (InputStream in = SqlTracker
                .class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker
                    .findByName("name")
                    .size(),
                    is(1));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenShowAll() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("one"));
            tracker.add(new Item("two"));
            assertThat(tracker
                    .findAll()
                    .size(),
                    is(2));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenReplaceItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("one"));
            tracker.replace(tracker.findByName("one").get(0).getId(), new Item("two"));
            assertThat(tracker
                    .findByName("two")
                    .size(),
                    is(1));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("one"));
            tracker.delete(tracker.findByName("one").get(0).getId());
            assertThat(tracker
                    .findByName("two")
                    .size(),
                    is(0));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenFindById() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("one"));
            assertThat(tracker.findById(tracker
                    .findByName("one")
                    .get(0)
                    .getId())
                    .getName(),
                    is("one"));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenFindByName() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("one"));
            assertThat(tracker
                    .findByName("one")
                    .size(),
                    is(1));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenFindAllByOrderNameAsc() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("bbb"));
            tracker.add(new Item("aaa"));
            assertThat(tracker
                    .findAllByOrder("name", "asc")
                    .get(0).getName(),
                    is("aaa"));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenFindAllByOrderNameDesc() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("bbb"));
            tracker.add(new Item("aaa"));
            assertThat(tracker
                    .findAllByOrder("name", "desc")
                    .get(0)
                    .getName(),
                    is("bbb"));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenFindAllByOrderIdAsc() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("bbb"));
            tracker.add(new Item("aaa"));
            assertThat(tracker.findAllByOrder("id", "asc").get(0).getName(), is("bbb"));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenFindAllByOrderIdDesc() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("bbb"));
            tracker.add(new Item("aaa"));
            assertThat(tracker.findAllByOrder("id", "desc").get(0).getName(), is("aaa"));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Store memTracker = new SqlTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
       new StartUI(out).init(in, memTracker, actions);
        Assert.assertThat(out.toString(), is(
                "Menu" + System.lineSeparator()
                        + "0.Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Store memTracker = new SqlTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        Assert.assertThat(out.toString(), is(
                "Menu" + ln
                + "0.Exit program" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu" + ln
                + "0.Exit program" + ln
        ));
    }

    @Test
    public void whenDeleteAction() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input input = mock(Input.class);
            Item itemBuff = tracker.add(new Item("deleteItem"));
            int idItemBuff = itemBuff.getId();
            DeleteAction del = new DeleteAction(out);
            when(input.askInt(any(String.class))).thenReturn(1);
            when(input.askInt(any(String.class))).thenReturn(idItemBuff);
            del.execute(input, tracker);
            String ln = System.lineSeparator();
            assertThat(out.toString(), is("=== Delete item ==="
                    + ln
                    + "Deleting is successful"
                    + ln));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenFindByIdAction() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input input = mock(Input.class);
            String name = "nameItem";
            Item itemBuff = tracker.add(new Item(name));
            int idItemBuff = itemBuff.getId();
            FindByIDAction findById = new FindByIDAction(out);
            when(input.askInt(any(String.class))).thenReturn(1);
            when(input.askInt(any(String.class))).thenReturn(idItemBuff);
            findById.execute(input, tracker);
            String ln = System.lineSeparator();
            assertThat(out.toString(), is("=== Find item by ID ==="
                    + ln
                    + "Result: " + itemBuff.toString()
                    + ln));
        } catch (Exception e) {

        }
    }

    @Test
    public void whenFindByNameAction() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input input = mock(Input.class);
            String name = "nameItem";
            Item itemBuff = tracker.add(new Item(name));
            FindByNameAction findByName = new FindByNameAction(out);
            when(input.askInt(any(String.class))).thenReturn(1);
            when(input.askStr(any(String.class))).thenReturn(name);
            findByName.execute(input, tracker);
            String ln = System.lineSeparator();
            assertThat(out.toString(), is("=== Find item by Name ==="
                    + ln
                    + itemBuff.toString()
                    + ln));
        } catch (Exception e) {

        }
    }
}
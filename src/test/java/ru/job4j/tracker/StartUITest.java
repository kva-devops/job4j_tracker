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
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

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
}
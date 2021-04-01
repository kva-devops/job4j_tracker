package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UniqueTextTest {

    @Test
    public void testIsEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats a mouse and milk";
        Assert.assertThat(UniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void testIsNotEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "A mouse is eaten by a cat";
        Assert.assertThat(UniqueText.isEquals(origin, text), is(false));
    }
}
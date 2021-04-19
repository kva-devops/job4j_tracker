package ru.job4j.search;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class PriorityQueueTest {

    @Test
    public void testHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        Assert.assertThat(result.getDesc(), is("urgent"));
    }
}
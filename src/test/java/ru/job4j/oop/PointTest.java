package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.hamcrest.Matchers.closeTo;

public class PointTest extends TestCase {

    public void testDistance() {
        Point a = new Point(1, 2);
        Point b = new Point(10, 10);
        double rsl = a.distance(b);
        Assert.assertThat(rsl, closeTo(12.04, 0.01));
    }

    public void testDistance3d() {
        Point a = new Point(1, 1, 1);
        Point b = new Point(10, 10, 10);
        double rsl = a.distance3d(b);
        Assert.assertThat(rsl, closeTo(15.59, 0.01));
    }
}
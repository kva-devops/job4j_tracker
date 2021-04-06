package ru.job4j.oop;

import junit.framework.TestCase;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void testPeriod() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.period(a.distance(b), a.distance(c), b.distance(c));
        assertThat(rsl, closeTo(6.828, 0.001));
    }

    @Test
    public void testExist() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        double ab = a.distance(b);
        double ac = a.distance(c);
        double bc = b.distance(c);
        Triangle triangle = new Triangle(a, b, c);
        boolean rsl = triangle.exist(ab, ac, bc);
        assertThat(rsl, is(true));
    }

    @Test
    public void testArea() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }
}
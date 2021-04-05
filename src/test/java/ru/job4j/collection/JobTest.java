package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.equalTo;
import java.util.Comparator;

public class JobTest {
    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpAscByName = new JobAscByName();
        int rsl = cmpAscByName.compare(
                new Job("Impl", 0),
                new Job("Fix bug", 1));
        Assert.assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpDescByName = new JobDescByName();
        int rsl = cmpDescByName.compare(
                new Job("Impl", 0),
                new Job("Fix bug", 1));
        Assert.assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpAscByPriority = new JobAscByPriority();
        int rsl = cmpAscByPriority.compare(
                new Job("Impl", 0),
                new Job("Fix bug", 1));
        Assert.assertThat(rsl, equalTo(-1));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpDescByPriority = new JobDescByPriority();
        int rsl = cmpDescByPriority.compare(
                new Job("Impl", 10),
                new Job("Fix bug", 20));
        Assert.assertThat(rsl, equalTo(1));
    }

    @Test
    public void whenComparatorAscByNameAndAscByPriority() {
        Comparator<Job> cmpAscByNameAndAscByPriority = new JobAscByName().
                thenComparing(new JobAscByPriority());
        int rsl = cmpAscByNameAndAscByPriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        Assert.assertThat(rsl, equalTo(-1));
    }

    @Test
    public void whenComparatorAscByNameAndDescByPriority() {
        Comparator<Job> cmpAscByNameAndDescByPriority = new JobAscByName().
                thenComparing(new JobDescByPriority());
        int rsl = cmpAscByNameAndDescByPriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        Assert.assertThat(rsl, equalTo(1));
    }

    @Test
    public void whenComparatorDescByNameAndDescByPriority() {
        Comparator<Job> cmpDescByNameAndDescByPriority = new JobDescByName().
                thenComparing(new JobDescByPriority());
        int rsl = cmpDescByNameAndDescByPriority.compare(
                new Job("Impl", 1),
                new Job("Fix bug", 1)
        );
        Assert.assertThat(rsl, lessThan(0));
    }
}
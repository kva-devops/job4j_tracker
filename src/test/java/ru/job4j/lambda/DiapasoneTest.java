package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.lambda.Diapasone;

import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.List;

public class DiapasoneTest {

    @Test
    public void whenLinearFunctionThenLinearRes() {
        List<Double> result = Diapasone.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenQuadFunctionThenQuadRes() {
        List<Double> result = Diapasone.diapason(5, 8, x -> x * x + x);
        List<Double> expected = Arrays.asList(30D, 42D, 56D);
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenPowFunctionThenPowRes() {
        List<Double> result = Diapasone.diapason(5, 8, x -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(3125D, 15625D, 78125D);
        Assert.assertThat(result, is(expected));
    }
}
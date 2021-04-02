package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("32dsdf", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        Assert.assertThat(map.get("32dsdf"),
                is(new Order("32dsdf", "Dress")));
    }
}
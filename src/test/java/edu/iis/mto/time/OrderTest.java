package edu.iis.mto.time;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class OrderTest {

    @Test(expected = OrderExpiredException.class)
    public void testOrderConfirmedAfterValidPeriodHours() {
        Order order = new Order(new FakeClock());
        order.submit();
        order.confirm();
    }

    @Test
    public void testOrderConfirmedInValidPeriodHours() {
        Order order = new Order(new RealClock());
        order.submit();
        order.confirm();

        Assert.assertThat(order.getOrderState(), is(Order.State.SUBMITTED));
    }

}

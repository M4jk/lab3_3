package edu.iis.mto.time;

import org.junit.Test;

public class OrderTest {

    @Test(expected = OrderExpiredException.class)
    public void testOrderConfirmedAfterValidPeriodHours() {
        Order order = new Order(new FakeClock());
        order.submit();
        order.confirm();
    }

}

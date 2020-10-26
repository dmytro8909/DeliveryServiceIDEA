package entities;

import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class for testing Order class
 * Created by dmytro on 10/26/20
 */
public class OrderTest {

    @Mock
    Order order = mock(Order.class);
    Date date = new Date("10/10/20");

    @Test
    public void testOrder() {
        when(order.getId()).thenReturn(2);
        when(order.getDescription()).thenReturn("Some description");
        when(order.getShippingDate()).thenReturn(date);
        when(order.getAddress()).thenReturn("Street, building, 123-4567");
        when(order.getCost()).thenReturn(BigDecimal.valueOf(300));
        when(order.getUserId()).thenReturn(4);
        when(order.getUserName()).thenReturn("User");
        when(order.getDirectionId()).thenReturn(3);
        when(order.getDirection()).thenReturn("direction");

        assertEquals(order.getId(), 2);
        assertEquals(order.getDescription(), "Some description");
        assertEquals(order.getShippingDate(), date);
        assertEquals(order.getAddress(), "Street, building, 123-4567");
        assertEquals(order.getCost(), BigDecimal.valueOf(300));
        assertEquals(order.getUserId(), 4);
        assertEquals(order.getUserName(), "User");
        assertEquals(order.getDirectionId(), 3);
        assertEquals(order.getDirection(), "direction");
    }

}
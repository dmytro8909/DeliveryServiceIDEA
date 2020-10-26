package entities;

import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

/**
 * Class for testing Bill class
 * Created by Dmytro Vereshchaka on 10/26/20
 */
public class BillTest {

    @Mock
    Bill bill = mock(Bill.class);
    Date date = new Date("10/10/20");

    @Test
    public void testBill() {
        when(bill.getId()).thenReturn(2);
        when(bill.getOrderId()).thenReturn(3);
        when(bill.getOrderDescription()).thenReturn("Some description");
        when(bill.getOrderAddress()).thenReturn("Street, building, 555-5555");
        when(bill.getOrderDirection()).thenReturn("Kyiv-Kharkiv");
        when(bill.getOrderCost()).thenReturn(BigDecimal.valueOf(100.00));
        when(bill.getOrderShippingDate()).thenReturn(date);
        when(bill.getOrderUserName()).thenReturn("User");
        when(bill.getUserId()).thenReturn(5);
        when(bill.getDirectionId()).thenReturn(4);
        when(bill.getStatus()).thenReturn("paid");

        assertEquals(bill.getId(), 2);
        assertEquals(bill.getOrderId(), 3);
        assertEquals(bill.getOrderDescription(), "Some description");
        assertEquals(bill.getOrderAddress(), "Street, building, 555-5555");
        assertEquals(bill.getOrderDirection(), "Kyiv-Kharkiv");
        assertEquals(bill.getOrderCost(), BigDecimal.valueOf(100.00));
        assertEquals(bill.getOrderShippingDate(), date);
        assertEquals(bill.getOrderUserName(), "User");
        assertEquals(bill.getUserId(), 5);
        assertEquals(bill.getDirectionId(), 4);
        assertEquals(bill.getStatus(), "paid");
    }

}
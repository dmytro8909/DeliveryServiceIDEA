package dao;

import entities.Bill;
import entities.User;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by dmytro on 10/26/20
 */
public class BillDAOTest {

    @Mock
    private Bill bill = mock(Bill.class);

    @Mock
    private Bill bill1 = mock(Bill.class);

    @Mock
    private Bill bill2 = mock(Bill.class);

    @Mock
    private Bill bill3 = mock(Bill.class);

    @Mock
    private BillDAO billDAO = mock(BillDAO.class);

    private Date date = new Date("10/10/20");


    @Test
    public void testGetAll() {
        List<Bill> bills = new ArrayList<>();

        bill1.setId(1);
        bill1.setOrderId(2);
        bill1.setOrderDescription("Some description");
        bill1.setOrderAddress("Street, building, phone number");
        bill1.setOrderDirection("Kyiv-Kharkiv");
        bill1.setOrderCost(BigDecimal.valueOf(200.00));
        bill1.setOrderShippingDate(date);
        bill1.setOrderUserName("User");
        bill1.setUserId(5);
        bill1.setDirectionId(3);
        bill1.setStatus("not_paid");

        bill2.setId(2);
        bill2.setOrderId(3);
        bill2.setOrderDescription("Some description");
        bill2.setOrderAddress("Street, building, phone number");
        bill2.setOrderDirection("Kyiv-Poltava");
        bill2.setOrderCost(BigDecimal.valueOf(300.00));
        bill2.setOrderShippingDate(date);
        bill2.setOrderUserName("User");
        bill2.setUserId(6);
        bill2.setDirectionId(1);
        bill2.setStatus("paid");

        bill3.setId(4);
        bill3.setOrderId(7);
        bill3.setOrderDescription("Some description");
        bill3.setOrderAddress("Street, building, phone number");
        bill3.setOrderDirection("Kyiv-Lviv");
        bill3.setOrderCost(BigDecimal.valueOf(500.00));
        bill3.setOrderShippingDate(date);
        bill3.setOrderUserName("User");
        bill3.setUserId(8);
        bill3.setDirectionId(7);
        bill3.setStatus("paid");

        bills.add(bill1);
        bills.add(bill2);
        bills.add(bill3);

        given(billDAO.getAll()).willReturn(bills);

        List<Bill> expected = billDAO.getAll();

        assertEquals(expected, bills);

    }

    @Test
    public void testInsertBill() {
        
    }

}
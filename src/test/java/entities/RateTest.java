package entities;

import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class for testing Rate class
 * Created by Dmytro Vereshchaka on 10/26/20
 */
public class RateTest {

    @Mock
    Rate rate = mock(Rate.class);

    @Test
    public void testRate() {
        when(rate.getId()).thenReturn(2);
        when(rate.getName()).thenReturn("up_to_two");
        when(rate.getRate()).thenReturn(BigDecimal.valueOf(200));

        assertEquals(rate.getId(), 2);
        assertEquals(rate.getName(), "up_to_two");
        assertEquals(rate.getRate(), BigDecimal.valueOf(200));
    }

}
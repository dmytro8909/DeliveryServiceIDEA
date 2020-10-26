package entities;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class for testing Direction class
 * Created by dmytro on 10/26/20
 */
public class DirectionTest {

    @Mock
    Direction direction = mock(Direction.class);

    @Test
    public void testDirection() {
        when(direction.getId()).thenReturn(3);
        when(direction.getDirection()).thenReturn("Kyiv-Kharkiv");
        when(direction.getDistance()).thenReturn(500);

        assertEquals(direction.getId(), 3);
        assertEquals(direction.getDirection(), "Kyiv-Kharkiv");
        assertEquals(direction.getDistance(), 500);
    }

}
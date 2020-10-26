package entities;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class for testing Entity class
 * Created by dmytro on 10/26/20
 */
public class EntityTest {

    @Mock
    Entity entity = mock(Entity.class);

    @Test
    public void testEntity() {
        when(entity.getId()).thenReturn(2);
        assertEquals(entity.getId(), 2);
    }

}
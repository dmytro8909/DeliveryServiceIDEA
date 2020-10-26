package entities;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Dmytro Vereshchaka on 10/26/20
 */
public class UserTest {

    @Mock
    User user = mock(User.class);

    @Test
    public void testUser() {
        when(user.getId()).thenReturn(1);
        when(user.getName()).thenReturn("userName");
        when(user.getLastName()).thenReturn("userLastName");
        when(user.getLogin()).thenReturn("login");
        when(user.getPassword()).thenReturn("password");
        when(user.getRole()).thenReturn("manager");
        when(user.getLocal()).thenReturn("ua");

        assertEquals(user.getId(), 1);
        assertEquals(user.getName(), "userName");
        assertEquals(user.getLastName(), "userLastName");
        assertEquals(user.getLogin(), "login");
        assertEquals(user.getPassword(), "password");
        assertEquals(user.getRole(), "manager");
        assertEquals(user.getLocal(), "ua");
    }

}
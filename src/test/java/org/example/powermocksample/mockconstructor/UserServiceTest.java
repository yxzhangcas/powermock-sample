package org.example.powermocksample.mockconstructor;

// Mockito + PowerMock + TestNG
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@PrepareForTest({UserService.class})
public class UserServiceTest extends PowerMockTestCase {

    @Test
    public void testSave() {
        try {
            final UserDao userDao = PowerMockito.mock(UserDao.class);
            PowerMockito.doNothing().when(userDao).insert();
            String username = "username";
            String password = "password";
            PowerMockito.whenNew(UserDao.class).withArguments(username, password).thenReturn(userDao);

            final UserService userService = new UserService();
            userService.save(username, password);

            Mockito.verify(userDao).insert();
        } catch (Exception e) {
            fail();
        }
    }
}
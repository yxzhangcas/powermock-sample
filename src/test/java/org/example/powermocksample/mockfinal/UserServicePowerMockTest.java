package org.example.powermocksample.mockfinal;

// Mockito + PowerMock + TestNG
import org.example.powermocksample.common.User;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * final 类无法直接集成，故需要修改对应的字节码，虽然实际执行代码和无final的类相同。
 */

@PrepareForTest({UserDao.class})
public class UserServicePowerMockTest extends PowerMockTestCase {

    @Test
    public void testQueryUserCount() {
        final UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(userDao.getCount()).thenReturn(10);
        final UserService userService = new UserService(userDao);
        final int userCount = userService.queryUserCount();
        assertEquals(userCount, 10);
    }

    @Test
    public void testSaveUser() {
        final UserDao userDao = PowerMockito.mock(UserDao.class);
        final User user = new User();
        PowerMockito.doNothing().when(userDao).insertUser(user);
        final UserService userService = new UserService(userDao);
        userService.saveUser(user);
        Mockito.verify(userDao).insertUser(user);
    }
}
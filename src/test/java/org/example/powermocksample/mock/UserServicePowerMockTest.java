package org.example.powermocksample.mock;

// Mockito + PowerMock + TestNG
import org.example.powermocksample.common.User;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
import org.testng.annotations.Test;

// UT的类名必须以Test结尾，否则maven不会执行此UT
public class UserServicePowerMockTest {
    @Test
    public void testQueryUserCount2() {
        final UserDao userDao = PowerMockito.mock(UserDao.class);
        // when A.B then do C
        PowerMockito.when(userDao.getCount()).thenReturn(10);
        // do C when A do B
        PowerMockito.doReturn(10).when(userDao).getCount();

        final UserService userService = new UserService(userDao);
        final int userCount = userService.queryUserCount();

        Assert.assertEquals(userCount, 10);
    }

    @Test
    public void testSaveUser() {
        final UserDao userDao = PowerMockito.mock(UserDao.class);

        final User user = new User();

        PowerMockito.doNothing().when(userDao).insertUser(user);

        final UserService userService = new UserService(userDao);
        userService.saveUser(user);

        //PowerMock中没有verify
        Mockito.verify(userDao).insertUser(user);
    }
}

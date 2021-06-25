package org.example.powermocksample.mocklocal;

// Mockito + PowerMock + TestNG
import org.example.powermocksample.common.User;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * JUnit4实现注入的方法：
 * @RunWith(PowerMockRunner.class)
 * @PrepareFotTest({xxx.class, xxx.class})
 *
 * TestNG实现注入的方法：
 * 方法1：
 * @PrepareForTest({xxx.class, xxx.class})
 * public class xxxTest extends PowerMockTestCase
 * 方法2：
 * @PrepareForTest({xxx.class, xxx.class})
 * @ObjectFactory
 * public ITestObjectFactory getObjectFactory() {
 *     return new PowerMockObjectFactory();
 * }
 */
@PrepareForTest({UserService.class})    //mock内容要注入的类
public class UserServiceTest extends PowerMockTestCase {    //实现注入的方法1

    @Test
    public void testQueryUserCount() {
        try {
            final UserService userService = new UserService();

            final UserDao userDao = PowerMockito.mock(UserDao.class);
            PowerMockito.doReturn(10).when(userDao).getCount();
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);      //注入mock对象

            final int userCount = userService.queryUserCount();
            Assert.assertEquals(userCount, 10);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSaveUser() {
        try {
            final UserService userService = new UserService();

            final User user = new User();
            final UserDao userDao = PowerMockito.mock(UserDao.class);
            PowerMockito.doNothing().when(userDao).insertUser(user);
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);

            userService.saveUser(user);

            Mockito.verify(userDao).insertUser(user);
        } catch (Exception e) {
            fail();
        }
    }
}
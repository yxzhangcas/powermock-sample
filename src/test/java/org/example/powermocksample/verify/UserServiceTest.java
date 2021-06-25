package org.example.powermocksample.verify;

// Mockito + PowerMock + TestNG
import org.example.powermocksample.common.User;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@PrepareForTest({UserService.class})
public class UserServiceTest extends PowerMockTestCase {

    @Test
    public void testSaveOrUpdate1() {
        try {
            final UserDao userDao = PowerMockito.mock(UserDao.class);
            final User user = new User();
            PowerMockito.when(userDao.getCount()).thenReturn(0);
            PowerMockito.doNothing().when(userDao).insertUser(user);
            PowerMockito.doNothing().when(userDao).updateUser(user);
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);

            final UserService userService = new UserService();
            userService.saveOrUpdate(user);

            Mockito.verify(userDao).insertUser(user);
            Mockito.verify(userDao, Mockito.never()).updateUser(user);

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSaveOrUpdate2() {
        try {
            final UserDao userDao = PowerMockito.mock(UserDao.class);
            final User user = new User();
            PowerMockito.when(userDao.getCount()).thenReturn(1);
            PowerMockito.doNothing().when(userDao).insertUser(user);
            PowerMockito.doNothing().when(userDao).updateUser(user);
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);

            final UserService userService = new UserService();
            userService.saveOrUpdate(user);

            Mockito.verify(userDao, Mockito.never()).insertUser(user);
            Mockito.verify(userDao).updateUser(user);

        } catch (Exception e) {
            fail();
        }
    }
}
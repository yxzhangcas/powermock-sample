package org.example.powermocksample.mockfinal;

// Mockito + TestNG
import org.example.powermocksample.common.User;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * FIXME Mockito does not work
 * Mockito cannot mock/spy because :
 *  - final or anonymous class
 */
public class UserServiceMockitoTest {

//    @Mock
//    private UserDao userDao;
//
//    @Test
//    public void testQueryUserCount() {
//        MockitoAnnotations.initMocks(this);
//        Mockito.when(userDao.getCount()).thenReturn(10);
//        final UserService userService = new UserService(userDao);
//        final int userCount = userService.queryUserCount();
//        assertEquals(userCount, 10);
//    }
//
//    @Test
//    public void testSaveUser() {
//        MockitoAnnotations.initMocks(this);
//        final User user = new User();
//        Mockito.doNothing().when(userDao).insertUser(user);
//        final UserService userService = new UserService(userDao);
//        userService.saveUser(user);
//        Mockito.verify(userDao).insertUser(user);
//    }
}
package org.example.powermocksample.mock;

// // Mockito + TestNG
import org.example.powermocksample.common.User;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserServiceMockitoTest {
    // Mockito支持注解Mock，PowerMock不支持注解Mock，需使用方法
    @Mock
    private UserDao userDao;

    @Test
    public void testQueryUserCount() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(userDao.getCount()).thenReturn(10);

        final UserService userService = new UserService(userDao);
        final int userCount = userService.queryUserCount();

        Assert.assertEquals(userCount, 10);
    }

    @Test
    public void testSaveUser() {
        MockitoAnnotations.initMocks(this);

        final User user = new User();

        Mockito.doNothing().when(userDao).insertUser(user);;

        final UserService userService = new UserService(userDao);
        userService.saveUser(user);

        Mockito.verify(userDao).insertUser(user);
    }
}

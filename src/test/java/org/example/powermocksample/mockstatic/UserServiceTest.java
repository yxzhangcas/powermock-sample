package org.example.powermocksample.mockstatic;

// Mockito + PowerMock + TestNG
import org.example.powermocksample.common.User;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@PrepareForTest({UserDao.class})
public class UserServiceTest extends PowerMockTestCase {

    @Test
    public void testQueryUserCount() {
        try {
            PowerMockito.mockStatic(UserDao.class);
            PowerMockito.when(UserDao.getCount()).thenReturn(10);
            final UserService userService = new UserService();
            final int userCount = userService.queryUserCount();
            Assert.assertEquals(userCount, 10);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSaveUser() {
        try {
            final User user = new User();
            PowerMockito.mockStatic(UserDao.class);
            PowerMockito.doNothing().when(UserDao.class);       //无返回值的不指定方法
            final UserService userService = new UserService();
            userService.saveUser(user);
            // FIXME verify方法中必须是mock对象，否则虽然此UT通过，但是afterxxx方法出错，还影像其它的Mock测试
            // FIXME 解决办法暂时还不知道，貌似可以使用spy?
//            PowerMockito.verifyStatic(UserDao.class, Mockito.times(1));     //PowerMock v2.x.x  执行成功，after失败
//            PowerMockito.verifyStatic(Mockito.times(1));    //PowerMock v1.x.x  执行成功
        } catch (Exception e) {
            fail();
        }
    }
}
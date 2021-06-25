package org.example.powermocksample.matcher;

// Mockito + PowerMock + TestNG
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@PrepareForTest({UserService.class})
public class UserServiceTest extends PowerMockTestCase {

    @Test
    public void testFind() {
        try {
            final UserDao userDao = PowerMockito.mock(UserDao.class);
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            PowerMockito.when(userDao.queryByName(Mockito.argThat(new MyMatcher()))).thenReturn("ME");

            final UserService userService = new UserService();
            final String zhang = userService.find("zhang");
            assertEquals(zhang, "ME");
            final String zyx = userService.find("zyx");
            assertEquals(zyx, "ME");
        } catch (Exception e) {
            fail();
        }
    }
}

class MyMatcher implements ArgumentMatcher<String> {
    @Override
//    public boolean matches(Object o) {        // Object for PowerMock 1.x.x
//        String name = (String) o;
    public boolean matches(String name) {       // <T> for PowerMock 2.x.x
        switch (name) {
            case "zhang":
            case "zyx":
            case "yuxiao":
            case "zhangyuxiao":
                return true;
            default:
                return false;
        }
    }
}
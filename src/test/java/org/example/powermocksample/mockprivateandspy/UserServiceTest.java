package org.example.powermocksample.mockprivateandspy;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@PrepareForTest({UserService.class})
public class UserServiceTest extends PowerMockTestCase {

    @Test
    public void testLog() {
        final UserService userService = PowerMockito.spy(new UserService());
        PowerMockito.doNothing().when(userService).log("zhang");

        userService.log("zhang");
        userService.log("li");
    }

    @Test
    public void testDoCheck() {
        try {
            final UserService userService = PowerMockito.spy(new UserService());
            PowerMockito.doReturn(true).when(userService, "check", "zhang");    // 私有方法
            final boolean check = userService.doCheck("zhang");
            assertTrue(check);
        } catch (Exception e) {
            fail();
        }
    }
}
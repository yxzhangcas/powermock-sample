package org.example.powermocksample.answer;

// Mockito + PowerMock + TestNG
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
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
            PowerMockito.when(userDao.queryByName(Mockito.anyString())).then(new Answer<String>() {
                @Override
                public String answer(InvocationOnMock invocationOnMock) throws Throwable {
//                    final String name = invocationOnMock.getArgumentAt(0, String.class);            // User for PowerMock 1.x.x
                    final String name = invocationOnMock.getArgument(0, String.class);              // User for PowerMock 2.x.x
                    switch (name) {
                        case "zhang":
                            return "zhangyuxiao";
                        case "li":
                            return "lihui";
                        default:
                            return "unknown";
                    }
                }
            });

            final UserService userService = new UserService();

            assertEquals("zhangyuxiao", userService.find("zhang"));
            assertEquals("lihui", userService.find("li"));
            assertEquals("unknown", userService.find("du"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
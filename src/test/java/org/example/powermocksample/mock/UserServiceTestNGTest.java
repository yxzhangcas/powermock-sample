package org.example.powermocksample.mock;

// TestNG
import org.example.powermocksample.common.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserServiceTestNGTest {

    private UserService userService;

    @BeforeTest
    public void before() {
        this.userService = new UserService(new UserDao());
    }

    @Test
    public void testQueryUserCount() {
        try {
            this.userService.queryUserCount();
            fail("should not be here");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testQueryUserCount1() {
        this.userService.queryUserCount();
    }

    @Test
    public void testSaveUser() {
        try {
            this.userService.saveUser(new User());
            fail("should not be here");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testSaveUser1() {
        this.userService.saveUser(new User());
    }

}
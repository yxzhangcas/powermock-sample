package org.example.powermocksample.mocklocal;

import org.example.powermocksample.common.User;

public class UserService {

    public int queryUserCount() {
        final UserDao userDao = new UserDao();
        return userDao.getCount();
    }

    public void saveUser(User user) {
        final UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}

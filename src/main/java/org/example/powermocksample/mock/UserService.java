package org.example.powermocksample.mock;

import org.example.powermocksample.common.User;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount() {
        return this.userDao.getCount();
    }

    public void saveUser(User user) {
        this.userDao.insertUser(user);
    }
}

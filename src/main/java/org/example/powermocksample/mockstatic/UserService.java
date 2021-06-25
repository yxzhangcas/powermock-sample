package org.example.powermocksample.mockstatic;

import org.example.powermocksample.common.User;

public class UserService {

    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void saveUser(User user) {
        UserDao.insertUser(user);
    }
}

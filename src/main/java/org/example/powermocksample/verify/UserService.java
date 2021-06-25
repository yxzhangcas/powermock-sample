package org.example.powermocksample.verify;

import org.example.powermocksample.common.User;

public class UserService {

    public void saveOrUpdate(User user) {
        final UserDao userDao = new UserDao();
        if (userDao.getCount() > 0) {
            userDao.updateUser(user);
        } else {
            userDao.insertUser(user);
        }
    }
}

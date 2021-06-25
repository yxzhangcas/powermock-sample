package org.example.powermocksample.matcher;

public class UserService {

    public String find(String name) {
        final UserDao userDao = new UserDao();
        return userDao.queryByName(name);
    }
}

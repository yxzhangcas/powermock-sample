package org.example.powermocksample.answer;

public class UserService {
    public String find(String name) {
        final UserDao userDao = new UserDao();
        return userDao.queryByName(name);
    }
}

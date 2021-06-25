package org.example.powermocksample.mockconstructor;

public class UserService {

    public void save(String username, String password) {
        final UserDao userDao = new UserDao(username, password);
        userDao.insert();
    }
}

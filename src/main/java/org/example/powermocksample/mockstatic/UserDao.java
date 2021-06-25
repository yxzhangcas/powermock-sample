package org.example.powermocksample.mockstatic;

import org.example.powermocksample.common.User;

public class UserDao {

    public static int getCount() {
        throw new UnsupportedOperationException();
    }

    public static void insertUser(User user) {
        throw new UnsupportedOperationException();
    }
}

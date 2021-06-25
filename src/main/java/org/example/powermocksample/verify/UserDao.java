package org.example.powermocksample.verify;

import org.example.powermocksample.common.User;

public class UserDao {
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    public void insertUser(User user) {
        throw new UnsupportedOperationException();
    }

    public void updateUser(User user) {
        throw new UnsupportedOperationException();
    }
}

package org.example.powermocksample.testng;

import org.example.powermocksample.common.User;

public class SampleDao {
    public void insertUser(User user) {
        throw new RuntimeException("database disconnected");
    }
}

package org.example.powermocksample.testng;

import org.example.powermocksample.common.User;

public class MockSampleDao extends SampleDao {
    @Override
    public void insertUser(User user) {
        System.out.println("insert user success");
    }
}

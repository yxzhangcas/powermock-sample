package org.example.powermocksample.testng;

import org.example.powermocksample.common.User;

public class SampleService {

    private final SampleDao sampleDao;

    public SampleService(SampleDao sampleDao) {
        this.sampleDao = sampleDao;
    }

    public void save(User user) {
        this.sampleDao.insertUser(user);
    }
}

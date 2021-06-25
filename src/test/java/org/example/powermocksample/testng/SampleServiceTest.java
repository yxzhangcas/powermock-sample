package org.example.powermocksample.testng;

// TestNG
import org.example.powermocksample.common.User;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleServiceTest {

    private SampleDao sampleDao;

    @BeforeTest
    public void before() {
        this.sampleDao = new MockSampleDao();
    }

    @Test
    public void testSave() {
        final SampleService sampleService = new SampleService(sampleDao);
        final User user = new User();
        sampleService.save(user);
    }
}
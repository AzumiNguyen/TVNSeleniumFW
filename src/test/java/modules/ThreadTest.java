package modules;

import org.testng.annotations.Test;

/**
 * Created by hado on 5/20/17.
 */
public class ThreadTest {
    @Test(threadPoolSize = 100, invocationCount = 100, timeOut = 1000)
    public void testMethod()
    {
        Long id = Thread.currentThread().getId();
        System.out.println("Test method executing on thread with id: " + id);
    }
}
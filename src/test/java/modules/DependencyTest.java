package modules;

import org.testng.annotations.Test;

/**
 * Created by hado on 3/18/17.
 */
public class DependencyTest {
    @Test(dependsOnMethods = {"testTwo"})
    public void testOne() {
        System.out.println("Test method one");
    }
    @Test
    public void testThree() {
        System.out.println("Test method three");
    }
    @Test
    public void testTwo() {
        System.out.println("Test method two");
    }
}

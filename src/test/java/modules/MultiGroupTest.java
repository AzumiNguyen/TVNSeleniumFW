package modules;

import org.testng.annotations.Test;

/**
 * Created by hado on 3/18/17.
 */
public class MultiGroupTest {
    @Test(groups = { "group-one" })
    public void testMethodOne() {
        System.out.println("Test method one belonging to group.");
    }

    @Test(groups = { "group-one", "group-two" })
    public void testMethodTwo() {
        System.out.println("Test method two belonging to both group.");
    }

    @Test(groups = { "group-two" })
    public void testMethodThree() {
        System.out.println("Test method three belonging to group.");
    }
    @Test(groups = { "group-two" })
    public void ID001Test() {
        System.out.println("Test method three belonging to group.");
    }
}

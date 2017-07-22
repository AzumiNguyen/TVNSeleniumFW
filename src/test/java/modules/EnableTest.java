package modules;

import org.testng.annotations.Test;

/**
 * Run from java file
 */
public class EnableTest {

    @Test
    public void testMethodOne() {
        System.out.println("Test method one.");
    }

    @Test(enabled = false)
    public void testMethodTwo() {
        System.out.println("Test method two.");
    }

    @Test
    public void testMethodThree() {
        System.out.println("Test method three.");
    }
}

